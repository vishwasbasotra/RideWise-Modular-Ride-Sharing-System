package com.airtribe.ridewise.model;

import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.util.IdGenerator;

import java.util.UUID;

public class Driver {
    private final String id;
    private final String name;
    private String location;
    private Availability availability;
    private int totalRides = 0;

    public Driver(DriverBuilder driverBuilder) {
        this.id = IdGenerator.generateDriverId();
        this.name = driverBuilder.name;
        this.location = driverBuilder.location;
        this.availability = driverBuilder.availability;
    }

    public String getName() {
        return name;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public void incrementRides(){
        this.totalRides++;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String currentLocation) {
        this.location = currentLocation;
    }

    public void setAvailable() {
        this.availability =  Availability.AVAILABLE;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setUnavailable() {
        this.availability =  Availability.UNAVAILABLE;
    }


    public void setAvailable(Availability available) {
        this.availability = available;
    }

    public static class DriverBuilder {
        private String name;
        private String location;
        private Availability availability = Availability.AVAILABLE;

        public DriverBuilder name(String name){
            this.name = name;
            return this;
        }

        public DriverBuilder location(String location){
            this.location = location;
            return this;
        }

        public DriverBuilder availability(Availability availability){
            this.availability = availability;
            return this;
        }

        public Driver buildDriver(){
            return new Driver(this);
        }
    }

}
