package com.airtribe.ridewise.strategy.fare;

import com.airtribe.ridewise.model.Ride;

public class PeakHourFareStrategy implements FareStrategy{
    private static final double BASE_RATE = 10.0;
    private static final double PEAK_MULTIPLIER = 1.5;
    @Override
    public double calculateFare(Ride ride) {
        return ride.getDistance()*BASE_RATE*PEAK_MULTIPLIER;
    }
}
