package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessingGame {
    private final BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));

    private boolean determineWin(int randomNum, int userInt){


        if (userInt > randomNum) {
            System.out.println("Too high. Try again.\n");
        } else if (randomNum > userInt) {
            System.out.println("Too low. Try again.\n");
        } else {
            System.out.println("You win!");
            return true;
        }
        return false;
    }
    private int getInputInt(int bounds){
        int num = 0;
        do {
            System.out.print("Guess a number between 1 and "+String.valueOf(bounds)+": ");
            try {
                String thing = bread.readLine();
                num = Integer.parseInt(thing);
            } catch(IOException exception) {
                System.out.println("IO Exception;");
            } catch(NumberFormatException exception){
                System.out.println("Please input a correct input type.");
            }
        } while(num < 1 && num > bounds);
        return num;
    }
    private void CreateGame(int bounds){
        boolean win = false;
        Random rng = new Random();
        int randomNum = rng.nextInt(bounds) + 1;
        System.out.println("The secrete number is: "+randomNum);
        for(int i = 0; i < 5; i++){
            int userInput = getInputInt(bounds);
            win = determineWin(randomNum,userInput);
            if (win) break;
        }
        if(!win){
            System.out.println("You lose. The answer is " + randomNum);
        }
    }
    public void play(){
        System.out.print("Select difficulty: Easy, Medium, Hard: ");
        try {
            String uD = bread.readLine();
            switch (uD.toLowerCase()) {
                case "easy" -> CreateGame(10);
                case "medium" -> CreateGame(50);
                case "hard" -> CreateGame(100);
            }
        }
        catch(IOException IO){
            System.out.println("Please input a correct value type.");
        }
    }
}
