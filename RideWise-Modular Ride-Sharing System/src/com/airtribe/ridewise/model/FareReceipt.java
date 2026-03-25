package com.airtribe.ridewise.model;

import java.time.LocalDateTime;

public class FareReceipt {
    private String rideId;
    private double amount;
    private LocalDateTime generatedAr;

    public FareReceipt(String rideId, double amount, LocalDateTime generatedAr) {
        this.rideId = rideId;
        this.amount = amount;
        this.generatedAr = generatedAr;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getGeneratedAr() {
        return generatedAr;
    }

    public void setGeneratedAr(LocalDateTime generatedAr) {
        this.generatedAr = generatedAr;
    }
}
