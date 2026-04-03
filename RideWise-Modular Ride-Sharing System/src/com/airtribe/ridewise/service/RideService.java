package com.airtribe.ridewise.service;

import com.airtribe.ridewise.enums.RideStatus;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.FareReceipt;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.repository.DriverRepository;
import com.airtribe.ridewise.repository.RiderRepository;
import com.airtribe.ridewise.repository.RidesRepository;
import com.airtribe.ridewise.strategy.fare.FareStrategy;
import com.airtribe.ridewise.strategy.matching.RideMatchingStrategy;

import java.util.Scanner;

public class RideService {
    private DriverRepository driverRepository;
    private RiderRepository riderRepository;
    private RidesRepository ridesRepository;
    private Scanner sc;

    public RideService(DriverRepository driverRepository, RiderRepository riderRepository, RidesRepository ridesRepository) {
        this.driverRepository = driverRepository;
        this.riderRepository = riderRepository;
        this.ridesRepository = ridesRepository;
        this.sc = new Scanner(System.in);
    }

    public Ride requestRide(RideMatchingStrategy rideMatchingStrategy, FareStrategy fareStrategy, String riderId, double distance){
        Rider rider = riderRepository.getRiderById(riderId);
        Driver driver = assignDriver(rideMatchingStrategy, rider);

        Ride ride = new Ride(rider, driver, distance);

        double fare = fareStrategy.calculateFare(ride);
        ride.setFare(fare);

        driver.setUnavailable();
        ride.setRideStatus(RideStatus.ASSIGNED);

        ridesRepository.addRides(ride);

        System.out.println("Ride assigned to "+driver.getName()+". Total Fare: "+fare);
        return ride;
    }

    public String cancelRide(Ride ride){
        ride.setRideStatus(RideStatus.CANCELLED);
        ride.getDriver().setAvailable();
        return "Ride is cancelled!!!";
    }

    public FareReceipt completeRide(Ride ride){
        ride.setRideStatus(RideStatus.COMPLETED);
        ride.getDriver().setAvailable();
        ride.getDriver().incrementRides();

        System.out.println("Ride "+ride.getId()+" is completed. Driver "+
                ride.getDriver().getName()+" now has "+
                ride.getDriver().getTotalRides()+" total rides.");
        return new FareReceipt(ride.getFare(), ride.getId());
    }

    public Driver assignDriver(RideMatchingStrategy rideMatchingStrategy, Rider rider){
        return rideMatchingStrategy.findDriver(rider, driverRepository.getDrivers());
    }
}
