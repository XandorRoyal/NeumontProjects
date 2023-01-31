/**
 * @author xmartin
 * @createdOn 1/30/2023 at 11:09 AM
 * @projectName ZombieProject
 * @packageName csc150.zombiesproject.zombies;
 */
package csc150.zombiesproject.zombies;

import java.util.Random;

public class Walker extends Zombie {
    @Override
    public int attack(int hit) {
        int damage = 0;
        if (hit < 8) {
            return 0;
        } else {
            damage = roll(3,6);
        }
        return damage;
    }

    @Override
    protected boolean setBaseHp(int baseHp) {
        if (baseHp > 30 || baseHp < 15) return false;
        return super.setBaseHp(baseHp);
    }

    @Override
    protected boolean setSpeed(int speed) {
        if (speed > 10 || speed < 6) return false;
        return super.setSpeed(speed);
    }


    @Override
    public String toString(){
        return String.format("This Zombie is a Walker. %s", super.toString());
    }
    public Walker(){
        setBaseHp(rnd.nextInt(15,30));
        setSpeed(rnd.nextInt(6,10));
    }
    public Walker(int arms, int legs, int baseHp, int speed){
        super.setArms(arms);
        super.setLegs(legs);
        setBaseHp(baseHp);
        setSpeed(speed);
    }
}
