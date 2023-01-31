/**
 * @author xmartin
 * @createdOn 1/30/2023 at 11:10 AM
 * @projectName ZombieProject
 * @packageName csc150.zombiesproject.zombies;
 */
package csc150.zombiesproject.zombies;

public class Runner extends Zombie {
    private int climbSpeed;

    public void setClimbSpeed() {
        this.climbSpeed = (int) Math.floor(this.speed/3);
    }
    public int getClimbSpeed(){
        return this.climbSpeed;
    }

    @Override
    protected boolean setBaseHp(int baseHp) {
        if (baseHp > 22 || baseHp < 10) return false;
        return super.setBaseHp(baseHp);
    }

    @Override
    protected boolean setSpeed(int speed) {
        if (speed > 25 || speed < 15) return false;
        return super.setSpeed(speed);
    }

    @Override
    public int attack(int hit) {
        int damage = 0;
        if (hit < 5) {
            return 0;
        } else {
            damage = roll(2, 8);
        }
        return damage;
    }
    @Override
    public String toString(){
        return String.format("This Zombie is a Runner. %s It's climbing speed is %s.", super.toString(), this.climbSpeed);
    }
    public Runner(){
        setBaseHp(rnd.nextInt(10,22));
        setSpeed(rnd.nextInt(15,25));
        setClimbSpeed();
    }
    public Runner(int arms, int legs,int baseHp, int speed){
        super.setArms(arms);
        super.setLegs(legs);
        setBaseHp(baseHp);
        setSpeed(speed);
        setClimbSpeed();
    }
}
