package com.airtribe.ridewise.model;

import com.airtribe.ridewise.util.IdGenerator;

public class Rider {
    private final String id;
    private final String name;
    private String location;

    public Rider(String name, String location) {
        this.id = IdGenerator.generateRiderId();
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
