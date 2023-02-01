/**
 * @author xmartin
 * @createdOn 2/1/2023 at 10:31 AM
 * @projectName Interstate
 * @packageName csc150.interstate.controllers;
 */
package csc150.interstate.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterstateUI {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static String getString(String message){
        System.out.println(message);
        boolean bool = false;
        String input = "";
        do {
            try {
                input = bf.readLine();
            } catch (IOException exe) {
                System.out.println("Please reinput option: internal java error.");
                bool = true;
            }
        } while(bool);
        return input;
    }

    static String help(){
        return """
                1 | help: display help menu
                2: accelerate super car
                3: brake super car
                4: accelerate junk car
                5: brake junk car
                6: exit""";
    }
}
