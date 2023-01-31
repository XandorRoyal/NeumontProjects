/**
 * @author xmartin
 * @createdOn 1/30/2023 at 11:10 AM
 * @projectName ZombieProject
 * @packageName csc150.zombiesproject.zombies;
 */
package csc150.zombiesproject.zombies;

public class Tank extends Zombie {
    int damageModifier;
    public boolean setDamageModifier(int damageModifier) {
        if (damageModifier < 10 || damageModifier > 20) return false;
        this.damageModifier = damageModifier;
        return true;
    }
    protected int getDamageModifier(){
        return this.damageModifier;
    }
    @Override
    protected boolean setBaseHp(int baseHp) {
        if (baseHp > 70 || baseHp < 45) return false;
        super.setBaseHp(baseHp);
        return true;
    }
    @Override
    protected boolean setSpeed(int speed){
        if (speed > 70 || speed < 45) return false;
        super.setBaseHp(speed);
        return true;
    }

    @Override
    public int attack(int hit) {
        int damage = 0;
        if (hit < 10) {
            return 0;
        } else {
            damage = roll(3,6) + this.damageModifier;
        }
        return damage;
    }
    @Override
    public String toString(){
        return String.format("This Zombie is a Tank. %s It's damage modifier is %s.", super.toString(),this.damageModifier);
    }

    public Tank(){
        setBaseHp(rnd.nextInt(45,70));
        setSpeed(rnd.nextInt(4,8));
        setDamageModifier(rnd.nextInt(10,20));
    }
    public Tank(int arms, int legs,int baseHp, int speed, int damageModifier){
        super.setArms(arms);
        super.setLegs(legs);
        setBaseHp(baseHp);
        setSpeed(speed);
        setDamageModifier(damageModifier);
    }
}
