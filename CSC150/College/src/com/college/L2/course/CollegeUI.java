/**
 * @author xmartin
 * @createdOn 1/20/2023 at 10:38 AM
 * @projectName College
 * @packageName com.college.L2.course;
 */
package com.college.L2.course;

import com.college.L2.Status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class CollegeUI {
    static String getUserInput(String message){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(message);
        String out = "";
        try {
            out = bf.readLine();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        out = out.equals("") ? "N/A" : out;
        return out;
    }

    static String getString(String message){
        return getUserInput(message);
    }

    static int getInt(String message){
        int out = -1;
        boolean end = false;
        do {
            String input = getUserInput(message);
            try {
                out = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("Please input a valid number");
                continue;
            }
            end = true;
        } while(!end);
        return out;
    }

    static double getDouble(String message){
        double out = -1.0;
        boolean end = false;
        do {
            String input = getUserInput(message);
            try {
                out = Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.out.println("Please input a valid double");
                continue;
            }
            end = true;
        } while(!end);
        return out;
    }

    static boolean getBool(String message){
        boolean out;
        String input = getUserInput(message);
        out = Boolean.parseBoolean(input);
        return out;
    }

    static Status getEmploymentStatus(String message){
        Status status = Status.ADJUNCT;
        boolean end = false;
        do {
            String input = getString(message);
            try {
                status = Status.valueOf(input);
            } catch (IllegalArgumentException ex){
                System.out.println("Please input a valid status");
                continue;
            }
            end = true;
        } while (!end);
        return status;
    }

    static LocalTime[] getTimes(String message){
        LocalTime localTime1 = LocalTime.of(00,00,00);
        LocalTime localTime2 = LocalTime.of(01,00,00);
        LocalTime [] localTime = {localTime1,localTime2};
        boolean end = false;
        do {
            String input1 = getString(message+" (Starting time)");
            String input2 = getString(message+" (Ending time)");
            try{
                localTime1 = LocalTime.parse(input1+":00");
                localTime2 = LocalTime.parse(input2+":00");
            } catch (DateTimeParseException ex) {
                System.out.println("Please input valid format");
                continue;
            }
            end = true;
        } while(!end);
        return localTime;
    }

    static List getPerson(String type) {
        String name = CollegeUI.getString("Get "+type+" Name: ");
        LocalDate localDate = LocalDate.of(2000,1,1);
        boolean end = false;
        do {
            try {
                localDate = LocalDate.parse(CollegeUI.getString("Get Birthday (format: \"yyyy-mm-dd\"): "));
            } catch (DateTimeParseException ex){
                System.out.println("Please input valid format!");
                continue;
            }
            end = true;
        } while(!end);
        return Arrays.asList(name,localDate);
    }

    static String help(){
        return """
                1 | help: display help menu
                2: Add Staff member
                2b: Remove Staff Member
                3: Add Faculty member
                3b: Remove Faculty member
                4: Add Student member
                4b: Remove Student Member
                5: Assign Staff Member to Student
                5b: Remove Staff Member from Student
                6: Create Course/Class
                6b: Remove Course/Class
                7: Assign Faculty to Course
                7b: Remove Faculty from course
                8: Assign Student to Course
                8b: Remove Student from course
                9: Display College members
                10 | exit: Exit""";
    }
}
