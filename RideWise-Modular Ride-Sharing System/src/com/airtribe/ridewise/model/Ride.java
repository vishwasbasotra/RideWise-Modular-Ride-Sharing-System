package com.airtribe.ridewise.model;

import com.airtribe.ridewise.enums.RideStatus;
import com.airtribe.ridewise.util.IdGenerator;

public class Ride {
    private String id;
    private Rider rider;
    private Driver driver;
    private double distance;
    private RideStatus rideStatus;
    private double fare;

    public Ride(Rider rider, Driver driver, double distance) {
        this.id = IdGenerator.generateRideId();
        this.rider = rider;
        this.driver = driver;
        this.distance = distance;
        this.rideStatus = RideStatus.REQUESTED;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
