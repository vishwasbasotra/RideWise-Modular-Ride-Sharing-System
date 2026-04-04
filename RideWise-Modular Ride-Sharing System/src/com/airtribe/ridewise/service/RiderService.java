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

    public void riderManagement(int option) {
        switch (option){
            case 1:
                for (int i = 0; i < 50; i++) System.out.println(); //Print 50 new lines
                registerRider();
                break;
            case 2:
                for (int i = 0; i < 50; i++) System.out.println(); //Print 50 new lines
                for(Rider rider: riderRepository.getRiders()){
                    rider.display();
                }
                break;
            case 3:
                for (int i = 0; i < 50; i++) System.out.println(); //Print 50 new lines
                System.out.print("Enter Rider Id To Rider(Rider ids look like this 'RIDER-1'): ");
                String riderId = sc.next();
                getRiderById(riderId).display();
                break;
            case 4:
                return; // Returns to Main menu loop

        }
    }

    public Rider registerRider(){
        System.out.println("===========Registering a New Rider==========");
        System.out.print("Enter Full Name: ");
        String name = InputValidator.validateStringInput(sc.next());

        System.out.print("Enter Current Location: ");
        String currentLocation = InputValidator.validateStringInput(sc.next());

        Rider rider = new Rider.RiderBuilder().name(name).location(currentLocation).buildRider();
        riderRepository.addRider(rider);

        return rider;
    }

    public Rider getRiderById(String id){
        return riderRepository.getRiderById(id);
    }


}
