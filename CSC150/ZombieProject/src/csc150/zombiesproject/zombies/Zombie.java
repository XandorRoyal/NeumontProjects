/**
 * @author xmartin
 * @createdOn 1/30/2023 at 11:09 AM
 * @projectName ZombieProject
 * @packageName csc150.zombiesproject.zombies;
 */
package csc150.zombiesproject.zombies;

import java.util.Random;

abstract public class Zombie {
    protected Random rnd = new Random();
    protected int arms = rnd.nextInt(0,3);
    protected  int legs = rnd.nextInt(0,3);
    protected int baseHp;
    protected int speed;
    protected int getArms() {
        return this.arms;
    }
    protected boolean setArms(int arms) {
        if (arms > 2 || arms < 0) return false;
        this.arms = arms;
        return true;
    }
    protected int getLegs() {
        return this.legs;
    }
    protected boolean setLegs(int legs) {
        if (legs > 2 || legs < 0) return false;
        this.legs = legs;
        return true;
    }
    protected int getBaseHp() {
        return this.baseHp;
    }
    protected boolean setBaseHp(int baseHp) {
        this.baseHp = baseHp;
        return true;
    }
    protected int getSpeed() {
        return this.speed;
    }
    protected boolean setSpeed(int speed) {
        this.speed = speed;
        return true;
    }
    public int roll(int numberOfDice, int numberOfSides){
        int total = 0;
        for (int i = 0; i < numberOfDice; i++){
            total += rnd.nextInt(1, numberOfSides);
        }
        return total;
    }
    abstract int attack(int hit);

    @Override
    public String toString(){
        return String.format("This Zombie has %s legs and %s arms. It's speed is %s, and it's health is %s.", this.getLegs(), this.getArms(), this.getSpeed(), this.getBaseHp());
    }
}
