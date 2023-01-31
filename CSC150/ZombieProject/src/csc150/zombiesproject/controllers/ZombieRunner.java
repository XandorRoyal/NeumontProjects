/**
 * @author xmartin
 * @createdOn 1/30/2023 at 10:53 AM
 * @projectName ZombieProject
 * @packageName csc150.zombiesproject.controllers;
 */
package csc150.zombiesproject.controllers;

public class ZombieRunner {
    public void run(){

        mainLoop();
    }
    public void mainLoop(){
        System.out.println(ZombieConsole.help());
        do {
            boolean exit = ZombieConsole.determineInput();
            if (!exit) break;
        }while(true);
    }
}
