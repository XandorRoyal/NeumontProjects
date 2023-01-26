/**
 * @author xmartin
 * @createdOn 1/11/2023 at 1:31 PM
 * @projectName inheritance
 * @packageName edu.neumont.csc150;
 */
package edu.neumont.csc150;

public class Vehicles {
    private int horsePower;
    private double speed;

    protected double getSpeed() {
        return speed;
    }

    protected int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return String.format("This is a vehicle with %s horse power and a top speed of %s mph", getHorsePower(), getSpeed());
    }
    Vehicles(int horsePower, int speed){
        this.horsePower = horsePower;
        this.speed = speed;
    }
}
