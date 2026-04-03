package com.airtribe.ridewise.strategy.matching;

import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.exception.NoDriverAvailableException;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy{
    @Override
    public Driver findDriver(Rider rider, List<Driver> availableDrivers) {
        return availableDrivers.stream()
                .filter(d -> d.getLocation().equalsIgnoreCase(rider.getLocation()) &&
                        d.getAvailability() == Availability.AVAILABLE)
                .findFirst()
                .orElseThrow(() -> new NoDriverAvailableException("No drivers nearby!"));
    }
}
