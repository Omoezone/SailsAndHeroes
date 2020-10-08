package sailsandheroes.demo.Model;

public class Damage {
    public static int calculate(Ship shooter, Ship enemy, double hitChance){
        //damage formular (p. 16)
        // hitChance * Firing Power
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
    public static int crit(Ship shooter, Ship enemy, double crit){
        //cannon ball
            //1 Ship explodes
            //2 rudder lost (no future turning)
        //Chain shot
            //1 all riggin lost (ship breaks 1/turn)
            //2 33% of rigging lost
        //Grape Shot
            //1 -50% of sailors
            //2 -25% of salors
        return -1;
    }

    public static int collision(Ship ship, Ship ship2){
        //Hull damage = 1/3 of actual hull value of the other ship, i.e
        //Actual hull = previous actual hull - hull damage
        //All ships involved take damage
        return -1;
    }
}
