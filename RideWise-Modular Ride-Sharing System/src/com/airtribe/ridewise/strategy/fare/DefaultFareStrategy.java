package com.airtribe.ridewise.strategy.fare;

import com.airtribe.ridewise.model.Ride;

public class DefaultFareStrategy implements FareStrategy{
    private static final double RATE_PER_KM = 10.0;
    @Override
    public double calculateFare(Ride ride) {
        double vehicleMultiplier = ride.getDriver().getVehicleType().getMultiplier();
        return ride.getDistance() * RATE_PER_KM * vehicleMultiplier;
    }
}
