package com.airtribe.ridewise.repository;

import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.exception.NoDriverAvailableException;
import com.airtribe.ridewise.exception.RideNotFoundException;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;

import java.util.ArrayList;
import java.util.List;

public class RidesRepository {
    private List<Ride> rides;

    public RidesRepository() {
        this.rides = new ArrayList<>();
    }

    public List<Ride> getRides() {
        return rides;
    }

    public String addRides(Ride ride){
        rides.add(ride);
        return "New ride added successfully";
    }

    public Ride getRideById(String id){
        return rides.stream().filter(r -> r.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new RideNotFoundException("Ride not found!!!"));
    }
}
