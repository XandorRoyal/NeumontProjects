/**
 * @author xmartin
 * @createdOn 2/1/2023 at 10:30 AM
 * @projectName Interstate
 * @packageName csc150.interstate.models;
 */
package csc150.interstate.models;

public class JunkerCar implements Vehicle {
    private int speed = 0;
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void accelerate(){
        setSpeed(getSpeed()+1);
    }
    public void brake(){
        setSpeed(getSpeed() - 1);
    }

    @Override
    public String toString(){
        return String.format("This junk car has a speed of: %s",getSpeed());
    }
}
