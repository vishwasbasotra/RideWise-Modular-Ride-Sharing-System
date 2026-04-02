package com.airtribe.ridewise.repository;

import com.airtribe.ridewise.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepository {
    private List<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public String addDriver(Driver driver){
        drivers.add(driver);
        return "New driver added successfully";
    }

    public Driver getDriverById(String id){
        return drivers.stream().filter(d -> d.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Driver not found!!!"));
    }

    public void deleteDriverById(String id){
        drivers.removeIf(d -> d.getId().equalsIgnoreCase(id));
    }

    public void updateDriver(Driver driver){
        for (int i = 0; i < drivers.size(); i++) {
            if(drivers.get(i).getId().equals(driver.getId())){
                drivers.set(i, driver);
            }
        }
    }
}
