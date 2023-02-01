/**
 * @author xmartin
 * @createdOn 2/1/2023 at 10:29 AM
 * @projectName Interstate
 * @packageName csc150.interstate.controllers;
 */
package csc150.interstate.controllers;

import csc150.interstate.models.JunkerCar;
import csc150.interstate.models.SuperCar;
import csc150.interstate.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InterstateController {
    private Random rnd = new Random();
    public void run() {
        JunkerCar junk = new JunkerCar();
        SuperCar sup = new SuperCar();
        System.out.println(InterstateUI.help());
        while(true){
            String input = InterstateUI.getString("What would you like to do?");
            switch (input.toLowerCase()){
                case "1", "help":
                    System.out.println(InterstateUI.help());
                    break;
                case "2":
                    sup.accelerate();
                    System.out.println(sup);
                    break;
                case "3":
                    sup.brake();
                    System.out.println(sup);
                    break;
                case "4":
                    junk.accelerate();
                    System.out.println(junk);
                    break;
                case "5":
                    junk.brake();
                    System.out.println(junk);
                    break;
                case "6":
                    return;
            }
        }
    }
}
