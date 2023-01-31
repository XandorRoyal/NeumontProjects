/**
 * @author xmartin
 * @createdOn 1/30/2023 at 12:01 PM
 * @projectName ZombieProject
 * @packageName csc150.zombiesproject.controllers;
 */
package csc150.zombiesproject.controllers;

import csc150.zombiesproject.zombies.Runner;
import csc150.zombiesproject.zombies.Tank;
import csc150.zombiesproject.zombies.Walker;
import csc150.zombiesproject.zombies.Zombie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZedGenerator {
    Random rnd = new Random();
    public void generateZombie(int numberOfZombies){
        List<Zombie> zombieList = new ArrayList<>();
        for (int i = 0; i < numberOfZombies; i++){
            int randNum = rnd.nextInt(1,3);
            Zombie zomb = null;
            switch(randNum){
                case(1):
                    zomb = new Walker();
                    break;
                case(2):
                    zomb = new Runner();
                    break;
                case(3):
                    zomb = new Tank();
                    break;
            }
            if (zomb == null) continue;
            zombieList.add(zomb);
        }
        for (Zombie zomb : zombieList){
            System.out.println(zomb);
            int hit = 0;
            boolean crit = false;
            if (zomb instanceof Walker newZomb) {
                int roll = newZomb.roll(1,20);
                hit = newZomb.attack(roll);
                if (roll == 20) {
                    hit *= 2;
                    System.out.print("The zombie swings and hits a critical! He hits for "+hit+".\n");
                } else {
                    System.out.print("The zombie hits. He hits for "+hit+".\n");
                }
            } else if (zomb instanceof Runner newZomb) {
                int roll = newZomb.roll(1,20);
                hit = newZomb.attack(roll);
                if (roll > 18) {
                    hit *= 2;
                    System.out.print("The zombie swings and hits a critical! He hits for "+hit+".\n");
                } else {
                    System.out.print("The zombie hits. He hits for "+hit+".\n");
                }
            } else if (zomb instanceof Tank newZomb){
                int roll = newZomb.roll(1,20);
                hit = newZomb.attack(roll);
                if (roll == 20) {
                    hit *= 3;
                    System.out.print("The zombie swings and hits a critical! He hits for "+hit+".\n");
                } else {
                    System.out.print("The zombie hits. He hits for "+hit+".\n");
                }
            }
            if (hit == 0) {
                System.out.print("The zombie swings and misses.");
            }
        }
    }
}
