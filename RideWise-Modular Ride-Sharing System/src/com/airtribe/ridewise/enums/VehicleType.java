package com.airtribe.ridewise.enums;

public enum VehicleType {
    BIKE(1.0),
    AUTO(1.2),
    CAR(1.5);

    private final double multiplier;

    VehicleType(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
