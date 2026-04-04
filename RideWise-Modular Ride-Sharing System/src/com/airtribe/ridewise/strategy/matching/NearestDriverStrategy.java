package com.airtribe.ridewise.strategy.matching;

import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.exception.NoDriverAvailableException;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy{
    @Override
    public Driver findDriver(Rider rider, List<Driver> availableDrivers, VehicleType requestedType) {
        return availableDrivers.stream()
                .filter(d -> d.getAvailability() == Availability.AVAILABLE)
                .filter(d -> d.getLocation().equalsIgnoreCase(rider.getLocation()))
                // NEW FILTER: Only pick drivers with the matching vehicle type
                .filter(d -> d.getVehicleType() == requestedType)
                .findFirst()
                .orElseThrow(() -> new NoDriverAvailableException("No " + requestedType + " available in " + rider.getLocation()));
    }
}
