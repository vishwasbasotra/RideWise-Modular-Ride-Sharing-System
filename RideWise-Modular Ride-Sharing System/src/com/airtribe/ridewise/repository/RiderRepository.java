package com.airtribe.ridewise.repository;

import com.airtribe.ridewise.model.Rider;

import java.util.ArrayList;
import java.util.List;

public class RiderRepository {
    private List<Rider> riders;

    public RiderRepository() {
        this.riders = new ArrayList<>();
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public String addRider(Rider Rider){
        riders.add(Rider);
        return "New Rider added successfully";
    }

    public Rider getRiderById(String id){
        return riders.stream().filter(r -> r.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Rider not found!!!"));
    }

    public void deleteRiderById(String id){
        riders.removeIf(r -> r.getId().equalsIgnoreCase(id));
    }
}
