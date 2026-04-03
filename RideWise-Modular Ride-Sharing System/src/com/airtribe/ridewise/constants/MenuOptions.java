package com.airtribe.ridewise.constants;

import java.util.Scanner;

public class MenuOptions {
    static Scanner sc = new Scanner(System.in);

    public static int displayMainMenu(){
        System.out.println("\nLearner Track: Student & Course Management");
        System.out.println("------------------Menu--------------------");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("4. Exit");
        System.out.print("\nEnter 1-4 to select: ");
        return sc.nextInt();
    }

    public static int displayRiderMenu() {
        System.out.println("1. Add new student");
        System.out.println("2. View all students");
        System.out.println("3. Search student by ID");
        System.out.println("4. Activate/Deactivate a student");
        System.out.println("5. Exit");
        System.out.print("\nEnter 1-5 to select: ");
        return sc.nextInt();
    }

    public static int displayDriverMenu() {
        System.out.println("1. Add new course");
        System.out.println("2. View all courses");
        System.out.println("3. Activate/Deactivate a course");
        System.out.println("4. Exit");
        System.out.print("\nEnter 1-4 to select: ");
        return sc.nextInt();
    }

    public static int displayEnrollmentMenu() {
        System.out.println("1. Enroll a student in a course");
        System.out.println("2. View enrollments");
        System.out.println("3. Mark enrollment as completed/cancelled");
        System.out.println("4. Exit");
        System.out.print("\nEnter 1-4 to select: ");
        return sc.nextInt();
    }
}
