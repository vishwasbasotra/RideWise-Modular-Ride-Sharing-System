package com.airtribe.ridewise.util;

import com.airtribe.ridewise.enums.Availability;
import com.airtribe.ridewise.exception.InvalidInputException;

public class InputValidator {

    public static String validateStringInput(String input) {
        if(input == null || input.trim().isEmpty()){
            throw new InvalidInputException("Input cannot be null or empty.");
        }
        if(input.length() < 2){
            throw new InvalidInputException("Input is too short");
        }
        return input;
    }

    public static Availability validateAvailability(String input) {
        if(input == null){
            throw new InvalidInputException("Input cannot be null.");
        }

        try {
            return Availability.fromString(input.trim().toUpperCase());
        }catch (IllegalArgumentException e){
            throw new InvalidInputException("Invalid availability status. Please use: AVAILABLE, UNAVAILABLE");
        }
    }

    public static String validateYesAndNo(String input) {
        if(input == null || input.trim().isEmpty()){
            throw new InvalidInputException("Input cannot be null or empty.");
        }
        if(!input.equalsIgnoreCase("YES") && !input.equalsIgnoreCase("NO")){
            throw new InvalidInputException("Enter Input as YES or NO");
        }
        return input.toUpperCase();
    }
}
