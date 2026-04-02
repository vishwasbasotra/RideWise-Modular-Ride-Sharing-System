package com.airtribe.ridewise.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger driverCount = new AtomicInteger(1);
    private static final AtomicInteger riderCount = new AtomicInteger(1);

    public static String generateDriverId(){
        return "DRV-"+driverCount.getAndIncrement();
    }

    public static String generateRiderId(){
        return "DRV-"+riderCount.getAndIncrement();
    }
}
