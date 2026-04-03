package com.airtribe.ridewise.strategy.matching;

import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.exception.NoDriverAvailableException;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

import java.util.Comparator;
import java.util.List;

public class LeastActiveDriverStrategy implements RideMatchingStrategy{
    @Override
    public Driver findDriver(Rider rider, List<Driver> availableDrivers) {
        return availableDrivers.stream()
                .filter(d -> d.getAvailability() == Availability.AVAILABLE)
                .min(Comparator.comparingInt(Driver::getTotalRides))
                .orElseThrow(() -> new NoDriverAvailableException("No drivers available!"));
    }
}
