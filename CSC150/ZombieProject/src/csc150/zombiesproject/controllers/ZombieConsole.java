/**
 * @author xmartin
 * @createdOn 1/30/2023 at 10:54 AM
 * @projectName ZombieProject
 * @packageName csc150.zombiesproject.controllers;
 */
package csc150.zombiesproject.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZombieConsole {
    static ZedGenerator generator = new ZedGenerator();

    public static String getString(String message){
        // Internal Static method
        System.out.println(message);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String output = "";
        boolean complete = false;
        do {
            try {
                output = bf.readLine();
                complete = true;
            } catch (IOException exc) {
                exc.printStackTrace();
                System.out.println("Due to an internal error, please re insert input.");
            }
        }while(!complete);
        return output;
    }

    public static int getInt(String message){
        String input = getString(message);
        int output = -1;
        boolean complete = false;
        do {
            try {
                output = Integer.parseInt(input);
                complete = true;
            } catch (NumberFormatException ex){
                System.out.println("Please insert a valid number value.");
            }
        } while(!complete);
        return output;
    }

    public static boolean determineInput(){
        String message = "What would you like to do?";
        String input = getString(message);
        switch (input.toLowerCase()){
            case "1", "help":
                System.out.println(help());
                break;
            case "2":
                generator.generateZombie(1);
                break;
            case "3":
                generator.generateZombie(3);
                break;
            case "4":
                int numInp = getInt("Please input num");
                generator.generateZombie(numInp);
                break;
            case "5":
                return false;
        }
        return true;
    }
    public static String help(){
        return """
                1 | help: display help
                2: generate a random zombie!
                3: generate a few zombies.
                4: generate a number of zombies you provide!
                5: Exit""";
    }
}
