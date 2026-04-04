package com.airtribe.ridewise;

import com.airtribe.ridewise.constants.MenuOptions;
import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.enums.RideStatus;
import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.repository.DriverRepository;
import com.airtribe.ridewise.repository.RiderRepository;
import com.airtribe.ridewise.repository.RidesRepository;
import com.airtribe.ridewise.service.DriverService;
import com.airtribe.ridewise.service.RideService;
import com.airtribe.ridewise.service.RiderService;
import com.airtribe.ridewise.strategy.fare.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.fare.FareStrategy;
import com.airtribe.ridewise.strategy.fare.PeakHourFareStrategy;
import com.airtribe.ridewise.strategy.matching.LeastActiveDriverStrategy;
import com.airtribe.ridewise.strategy.matching.NearestDriverStrategy;
import com.airtribe.ridewise.strategy.matching.RideMatchingStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Initialize Repositories
        RiderRepository riderRepository = new RiderRepository();
        DriverRepository driverRepository = new DriverRepository();
        RidesRepository ridesRepository = new RidesRepository();

        // 2. Initialize Strategies
        RideMatchingStrategy nearestDriver = new NearestDriverStrategy();
        RideMatchingStrategy leastActive = new LeastActiveDriverStrategy();
        FareStrategy defaultFare = new DefaultFareStrategy();
        FareStrategy peakFare = new PeakHourFareStrategy();

        // 3. Initialize Services
        RiderService riderService = new RiderService(riderRepository);
        DriverService driverService = new DriverService(driverRepository);
        RideService rideService = new RideService(driverRepository, riderRepository, ridesRepository);

        // 4. Seed Data (Optional but helpful for testing)
        driverRepository.addDriver(new Driver.DriverBuilder().name("Sam").location("CP").vehicleType(VehicleType.BIKE).buildDriver());
        driverRepository.addDriver(new Driver.DriverBuilder().name("Tyler").location("Red Fort").vehicleType(VehicleType.CAR).buildDriver());
        driverRepository.addDriver(new Driver.DriverBuilder().name("Guts").location("CP").vehicleType(VehicleType.CAR).buildDriver());

        riderRepository.addRider(new Rider.RiderBuilder().name("Keila").location("CP").buildRider());

        Ride currentActiveRide = null;
        boolean running = true;

        while(running){
            try {
                int choice = MenuOptions.displayMainMenu();
                switch (choice){
                    case 1: // RIDER MANAGEMENT
                        riderService.riderManagement(MenuOptions.displayRiderMenu());
                        break;

                    case 2: // DRIVER MANAGEMENT
                        driverService.driverManagement(MenuOptions.displayDriverMenu());
                        break;

                    case 3: // VIEW AVAILABLE DRIVERS
                        System.out.println("\n--- Available Drivers ---");
                        driverRepository.availableDrivers().forEach(Driver::display);
                        break;

                    case 4: // REQUEST A RIDE
                        System.out.print("Enter Rider ID (e.g., RIDER-1): ");
                        String rId = sc.next();

                        System.out.print("Enter Vehicle Type (BIKE, AUTO, CAR): ");
                        String vInput = sc.next().toUpperCase();
                        VehicleType vType = VehicleType.valueOf(vInput);

                        System.out.print("Enter Distance (km): ");
                        double dist = sc.nextDouble();

                        // Orchestrate the request
                        currentActiveRide = rideService.requestRide(nearestDriver, defaultFare, rId, dist, vType);
                        System.out.println("\nRide successfully assigned!");
                        break;

                    case 5: // COMPLETE RIDE
                        if (currentActiveRide == null || currentActiveRide.getRideStatus() == RideStatus.COMPLETED) {
                            System.out.println("Error: No active ride found to complete.");
                        } else {
                            rideService.completeRide(currentActiveRide);
                            currentActiveRide = null; // Clear active ride slot
                        }
                        break;

                    case 6: // VIEW RIDE HISTORY
                        System.out.println("\n--- Ride History ---");
                        if(ridesRepository.getRides().isEmpty()) {
                            System.out.println("No history available.");
                        } else {
                            for(Ride ride : ridesRepository.getRides()) {
                                System.out.printf("ID: %s | Rider: %s | Driver: %s | Status: %s | Fare: ₹%.2f%n",
                                        ride.getId(), ride.getRider().getName(), ride.getDriver().getName(),
                                        ride.getRideStatus(), ride.getFare());
                            }
                        }
                        break;

                    case 7: // EXIT
                        System.out.println("Shutting down RideWise... Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid selection. Please enter 1-7.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Input Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("System Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}