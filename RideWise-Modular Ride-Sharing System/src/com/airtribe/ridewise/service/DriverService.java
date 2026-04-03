package com.airtribe.ridewise.service;

import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.model.Driver;
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

    public Driver registerNewDriver(){
        System.out.println("===========Registering a New Driver==========");
        System.out.print("Enter Full Name: ");
        String name = InputValidator.validateStringInput(sc.next());

        System.out.print("Enter Current Location: ");
        String location = InputValidator.validateStringInput(sc.next());

        System.out.print("Availability: ");
        Availability available = InputValidator.validateAvailability(sc.next());

        return new Driver.DriverBuilder().name(name).location(location).availability(available).buildDriver();
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
