package com.airtribe.ridewise.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger driverCount = new AtomicInteger(1);
    private static final AtomicInteger riderCount = new AtomicInteger(1);
    private static final AtomicInteger rideCount = new AtomicInteger(1);
    private static final AtomicInteger receiptCount = new AtomicInteger(1);

    public static String generateDriverId(){
        return "DRIVER-"+driverCount.getAndIncrement();
    }

    public static String generateRiderId(){
        return "RIDER-"+riderCount.getAndIncrement();
    }

    public static String generateRideId(){
        return "RIDE-"+rideCount.getAndIncrement();
    }

    public static String generateReceiptId(){
        return "RECEIPT-"+receiptCount.getAndIncrement();
    }
}
