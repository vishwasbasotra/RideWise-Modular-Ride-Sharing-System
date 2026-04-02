package com.airtribe.ridewise.model;

import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.util.IdGenerator;

import java.util.UUID;

public class Driver {
    private final String id;
    private final String name;
    private String currentLocation;
    private Availability availability;

    public Driver(DriverBuilder driverBuilder) {
        this.id = IdGenerator.generateDriverId();
        this.name = driverBuilder.name;
        this.currentLocation = driverBuilder.currentLocation;
        this.availability = driverBuilder.availability;
    }

    public String getId() {
        return id;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setAvailable() {
        this.availability =  Availability.AVAILABLE;
    }

    public void setUnavailable() {
        this.availability =  Availability.UNAVAILABLE;
    }


    public void setAvailable(Availability available) {
        this.availability = available;
    }

    public static class DriverBuilder {
        private String name;
        private String currentLocation;
        private Availability availability = Availability.AVAILABLE;

        public DriverBuilder name(String name){
            this.name = name;
            return this;
        }

        public DriverBuilder location(String location){
            this.currentLocation = location;
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
