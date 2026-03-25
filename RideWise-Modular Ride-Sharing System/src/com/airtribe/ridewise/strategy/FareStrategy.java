package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.model.Ride;

public interface FareStrategy {
    double calculateFate(Ride ride);
}
