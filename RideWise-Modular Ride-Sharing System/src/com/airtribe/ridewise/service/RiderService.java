package com.airtribe.ridewise.service;

import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.repository.RiderRepository;
import com.airtribe.ridewise.util.InputValidator;

import java.util.Scanner;

public class RiderService {
    private RiderRepository riderRepository;
    private Scanner sc;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
        this.sc = new Scanner(System.in);
    }

    public Rider registerRider(){
        System.out.println("===========Registering a New Rider==========");
        System.out.print("Enter Full Name: ");
        String name = InputValidator.validateStringInput(sc.next());

        System.out.print("Enter Current Location: ");
        String currentLocation = InputValidator.validateStringInput(sc.next());

        return new Rider.RiderBuilder().name(name).location(currentLocation).buildRider();
    }

    public Rider getRiderById(String id){
        return riderRepository.getRiderById(id);
    }
}
