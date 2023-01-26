/**
 * @author xmartin
 * @createdOn 1/11/2023 at 1:31 PM
 * @projectName inheritance
 * @packageName edu.neumont.csc150;
 */
package edu.neumont.csc150;

public class Truck extends Vehicles{
    private Color bodyColor;

    public Color getBodyColor() {
        return bodyColor;
    }

    @Override
    public String toString() {
        return String.format("This is a %s truck with a horse power of %s and a top speed of %s.", getBodyColor(), getHorsePower(), getSpeed());
    }

    Truck(int horsePower, int speed, Color bodyColor){
        super(horsePower,speed);
        this.bodyColor = bodyColor;
    }
}
