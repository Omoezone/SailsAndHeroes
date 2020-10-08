package sailsandheroes.demo.Model;

import java.util.Random;

public class Damage {
    // Lavet af Benjamin
    public static int calculate(Ship shooter, Ship enemy, double hitChance){
        //damage formular (p. 16)
        // hitChance * Firing Power
        shooter.calculatePowerValue();
        double damage = hitChance * shooter.getPowerValue();

        switch(shooter.getAmmunition()){
            case "Cannon Ball":
                enemy.setHullQuality(enemy.getHullQuality() - damage);
                break;
            case "Chain Shot":
                enemy.setSailQuality(enemy.getSailQuality() - damage);
                break;
            case "Grape Shot":
                enemy.setAmountOfSailors((int)(enemy.getAmountOfSailors() - damage));
                break;
        }
        return -1;
    }
    // Lavet af William
    public static void criticalShot(Ship shooter, Ship enemy, Random random){
        int crit = random.nextInt(20)+1;
            switch(shooter.getAmmunition()){
                // Ship explodes and hull health is set to 0
                case "Cannon Ball":
                    if(crit == 1) {
                        enemy.setHullQuality(0);
                        //TODO kill ship
                    }else if(crit == 2){
                        // TODO no more turning
                    }else
                        break;
                // x amount of sails is destroyed and set sail health to 0
                case "Chain Shot":
                    if(crit == 1) {
                        enemy.setSailQuality(0);
                    }else if(crit == 2){
                        enemy.setSailQuality(enemy.getSailQuality()- enemy.getSailQuality()/3);
                    }else
                        break;
                // Kill % of the sailors on a ship
                case "Grape Shot":
                    if(crit == 1){
                        enemy.setAmountOfSailors(enemy.getAmountOfSailors()/2);
                    }else if(crit == 2){
                        enemy.setAmountOfSailors(enemy.getAmountOfSailors()-enemy.getAmountOfSailors()/4);
                    }else
                        break;
            }
        }
    // MOVEMENT GUYS
    public static int collision(Ship ship, Ship ship2){
        //Hull damage = 1/3 of actual hull value of the other ship, i.e
        //Actual hull = previous actual hull - hull damage
        //All ships involved take damage
        return -1;
    }
}
