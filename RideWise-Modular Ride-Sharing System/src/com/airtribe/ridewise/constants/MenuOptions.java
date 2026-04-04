package com.airtribe.ridewise.constants;

import java.util.Scanner;

public class MenuOptions {
    static Scanner sc = new Scanner(System.in);

    public static int displayMainMenu(){
        System.out.println("\nRideWise —> Modular Ride-Sharing System");
        System.out.println("------------------Menu--------------------");
        System.out.println("1. Add Rider");
        System.out.println("2. Add Driver Management");
        System.out.println("3. View Available Drivers");
        System.out.println("4. Request A Ride");
        System.out.println("5. Complete Ride");
        System.out.println("6. View Rides");
        System.out.println("7. Exit ");
        System.out.print("\nEnter 1-7 to select: ");
        return sc.nextInt();
    }

    public static int displayRiderMenu() {
        System.out.println("1. Add new rider");
        System.out.println("2. View all riders");
        System.out.println("3. Search rider by ID");
        System.out.println("4. Exit");
        System.out.print("\nEnter 1-4 to select: ");
        return sc.nextInt();
    }

    public static int displayDriverMenu() {
        System.out.println("1. Add new driver");
        System.out.println("2. View all drivers");
        System.out.println("3. Search driver by ID");
        System.out.println("4. Exit");
        System.out.print("\nEnter 1-4 to select: ");
        return sc.nextInt();
    }
}
