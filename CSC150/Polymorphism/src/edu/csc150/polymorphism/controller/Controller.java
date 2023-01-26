/**
 * @author xmartin
 * @createdOn 1/23/2023 at 10:44 AM
 * @projectName Polymorphism
 * @packageName edu.csc150.polymorphism;
 */
package edu.csc150.polymorphism.controller;

import edu.csc150.polymorphism.model.Animal;
import edu.csc150.polymorphism.model.Elephant;
import edu.csc150.polymorphism.model.Mouse;

import java.util.ArrayList;

public class Controller {
    public void run(){
        ArrayList<Animal> arrayList = new ArrayList<>();

        Elephant ellie = new Elephant();
        Mouse mousie = new Mouse();

        arrayList.add(mousie);
        arrayList.add(ellie);

        for(Animal ele : arrayList) {
            if (ele instanceof Mouse mouse) {
                System.out.println(mouse.speak());
            } else if (ele instanceof Elephant elephant) {
                System.out.println(elephant.speak());
            }
        }


    }
}
