package com.airtribe.ridewise.repository;

import com.airtribe.ridewise.exception.RiderNotFoundException;
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
                .orElseThrow(() -> new RiderNotFoundException("Rider not found!!!"));
    }

    public void deleteRiderById(String id){
        riders.removeIf(r -> r.getId().equalsIgnoreCase(id));
    }

    public void updateRider(Rider rider){
        for (int i = 0; i < riders.size(); i++) {
            if(riders.get(i).getId().equals(rider.getId())){
                riders.set(i, rider);
            }
        }
    }
}
