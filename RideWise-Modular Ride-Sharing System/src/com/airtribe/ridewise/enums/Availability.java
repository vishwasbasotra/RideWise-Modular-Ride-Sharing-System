package com.airtribe.ridewise.enums;

public enum Availability {
    AVAILABLE,
    UNAVAILABLE;

    public static Availability fromString(String text) {
        if (text.equalsIgnoreCase("YES")) return AVAILABLE;
        if (text.equalsIgnoreCase("NO")) return UNAVAILABLE;
        throw new IllegalArgumentException("Use YES or NO");
    }
}
