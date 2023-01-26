/**
 * @author xmartin
 * @createdOn 1/11/2023 at 1:31 PM
 * @projectName inheritance
 * @packageName edu.neumont.csc150;
 */
package edu.neumont.csc150;

public class Wagon extends Vehicles{
    private int horseCount;

    public int getHorseCount() {
        return horseCount;
    }

    @Override
    public String toString() {
        return String.format("This is a %s horse wagon. It has a %s horse power and %s speed.", getHorseCount(), getHorsePower(), getSpeed());
    }
    Wagon(int horsePower, int speed, int horseCount){
        super(horsePower, speed);
        this.horseCount = horseCount;
    }
}
