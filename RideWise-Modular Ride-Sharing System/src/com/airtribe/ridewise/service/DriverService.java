package com.airtribe.ridewise.service;

import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.repository.DriverRepository;
import com.airtribe.ridewise.util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class DriverService {
    private DriverRepository driverRepository;
    private final Scanner sc;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
        this.sc = new Scanner(System.in);
    }

    public void driverManagement(int option) {
        switch (option){
            case 1:
                for (int i = 0; i < 50; i++) System.out.println(); //Print 50 new lines
                registerNewDriver();
                break;
            case 2:
                for (int i = 0; i < 50; i++) System.out.println(); //Print 50 new lines
                for(Driver driver: driverRepository.getDrivers()){
                    driver.display();
                }
                break;
            case 3:
                for (int i = 0; i < 50; i++) System.out.println(); //Print 50 new lines
                System.out.print("Enter Driver Id To Search(Driver ids look like this 'DRIVER-1'): ");
                String driverId = sc.next();
                driverRepository.getDriverById(driverId).display();
                break;
            case 4:
                return; // Returns to Main menu loop

        }
    }

    public Driver registerNewDriver(){
        System.out.println("===========Registering a New Driver==========");
        System.out.print("Enter Full Name: ");
        String name = InputValidator.validateStringInput(sc.next());

        System.out.print("Enter Current Location: ");
        String location = InputValidator.validateStringInput(sc.next());

        System.out.print("Availability: ");
        Availability available = InputValidator.validateAvailability(sc.next());

        Driver driver = new Driver.DriverBuilder().name(name).location(location).availability(available).buildDriver();
        driverRepository.addDriver(driver);
        System.out.println("Driver registered with ID: " + driver.getId());

        return driver;
    }

    public void updateDriverAvailability(String id){
        Driver driver = driverRepository.getDriverById(id);

        System.out.print("Enter driver availability-> yes or no:");
        String availability = InputValidator.validateYesAndNo(sc.next());

        if(availability.equalsIgnoreCase("YES"))    driver.setAvailable();
        else if(availability.equalsIgnoreCase("NO"))  driver.setUnavailable();

        driverRepository.updateDriver(driver);
        System.out.println("Driver updated successfully");
    }

    public List<Driver> availableDrivers(String currenLocation){
        return driverRepository.availableDriversByLocation(currenLocation);
    }
}
