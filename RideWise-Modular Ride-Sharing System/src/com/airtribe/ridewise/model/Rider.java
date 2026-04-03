package com.airtribe.ridewise.model;

import com.airtribe.ridewise.util.IdGenerator;

public class Rider {
    private final String id;
    private final String name;
    private String location;

    private Rider(RiderBuilder riderBuilder) {
        this.id = IdGenerator.generateRiderId();
        this.name = riderBuilder.name;
        this.location = riderBuilder.location;
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

    public static class RiderBuilder {
        private String name;
        private String location;

        public RiderBuilder name(String name){
            this.name = name;
            return this;
        }
        public RiderBuilder location(String location){
            this.location = location;
            return this;
        }

        public Rider buildRider(){
            return new Rider(this);
        }
    }
}
