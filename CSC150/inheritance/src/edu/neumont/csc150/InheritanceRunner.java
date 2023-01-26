/**
 * @author xmartin
 * @createdOn 1/11/2023 at 1:41 PM
 * @projectName inheritance
 * @packageName edu.neumont.csc150;
 */
package edu.neumont.csc150;

public class InheritanceRunner {
    public void run(){
        Vehicles vehicle1 = new Vehicles(5,3);
        Vehicles vehicle2 = new Vehicles(10,7);

        Truck redTruck = new Truck(250, 150, Color.RED);
        Truck blueTruck = new Truck(500, 250, Color.BLUE);

        Wagon fastWagon = new Wagon(2, 10, 2);
        Wagon slowWagon = new Wagon(1, 4, 1);

        System.out.println(vehicle2);
        System.out.println(redTruck);
        System.out.println(fastWagon);
    }
}
