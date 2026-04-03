package com.airtribe.ridewise.model;

import com.airtribe.ridewise.util.IdGenerator;

import java.time.LocalDateTime;

public class FareReceipt {
    private String receiptId;
    private String rideId;
    private double amount;
    private LocalDateTime generatedAt;

    public FareReceipt(double amount, String rideId) {
        this.receiptId = IdGenerator.generateReceiptId();
        this.rideId = rideId;
        this.amount = amount;
        this.generatedAt = java.time.LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

}
