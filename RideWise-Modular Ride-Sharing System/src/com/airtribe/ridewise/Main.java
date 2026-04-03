package com.airtribe.ridewise;

import com.airtribe.ridewise.constants.MenuOptions;
import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.model.Driver;
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

public class Main {
    public static void main(String[] args) {
        RiderRepository riderRepository = new RiderRepository();
        DriverRepository driverRepository = new DriverRepository();
        RidesRepository ridesRepository = new RidesRepository();

        driverRepository.addDriver(new Driver.DriverBuilder().name("Sam").availability(Availability.AVAILABLE).location("CP").buildDriver());
        driverRepository.addDriver(new Driver.DriverBuilder().name("Tyler").availability(Availability.AVAILABLE).location("Red Fort").buildDriver());
        driverRepository.addDriver(new Driver.DriverBuilder().name("Guts").availability(Availability.AVAILABLE).location("CP").buildDriver());
        driverRepository.addDriver(new Driver.DriverBuilder().name("Kafka").availability(Availability.AVAILABLE).location("Shalimar Bagh").buildDriver());
        driverRepository.addDriver(new Driver.DriverBuilder().name("Sullivan").availability(Availability.AVAILABLE).location("Red Fort").buildDriver());

        riderRepository.addRider(new Rider.RiderBuilder().name("Keila").location("CP").buildRider());
        riderRepository.addRider(new Rider.RiderBuilder().name("Lori").location("CP").buildRider());

        RideMatchingStrategy nearestDriver = new NearestDriverStrategy();
        RideMatchingStrategy leastActiveDriverStrategy = new LeastActiveDriverStrategy();

        FareStrategy defaultFareStrategy = new DefaultFareStrategy();
        FareStrategy peakHourFareStrategy = new PeakHourFareStrategy();

        RiderService riderService = new RiderService(riderRepository);
        DriverService driverService = new DriverService(driverRepository);
        RideService rideService = new RideService(driverRepository,riderRepository, ridesRepository);

        boolean running = true;
        while(running){
            int choice = MenuOptions.displayMainMenu();
            switch (choice){
                case 1:
                    for (int i = 0; i < 50; i++)    System.out.println();//Print 50 new lines

                    break;
                case 2:
                    for (int i = 0; i < 50; i++)    System.out.println(); //Print 50 new lines

                    break;
                case 3:
                    for (int i = 0; i < 50; i++)    System.out.println(); //Print 50 new lines

                    break;
                case 4:
                    System.out.println("Exiting RideWise. Goodbye!");
                    running = false; // Graceful exit
                    break;
                default:
                    System.out.println("Invalid Option. Try again.");
            }
        }
    }
}
