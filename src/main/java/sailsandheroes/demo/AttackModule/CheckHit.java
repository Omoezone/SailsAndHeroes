package sailsandheroes.demo.AttackModule;

import sailsandheroes.demo.GameModul.Damage;
import sailsandheroes.demo.Model.Ship;

import java.awt.*;
import java.util.Random;

public class CheckHit {

    //Benjamin
    public static boolean checkHit(Ship shooter, Ship enemy, Point point){
        Random random = new Random();

        //TODO WHAT IF ENEMY DOESN'T MOVE? THE LIST WOULD BE EMPTY NO? if (*statement* || point matches ship current position?)
        //Check center
        if(enemy.getPath().contains(new Point(point.x, point.y))){
            double chance = random.nextDouble();
            //40 percent for hit
            if(chance >= 0.4){
                //Calculate if crit
                if (chance <= 0.1){
                    //roll if crit hits
                    Damage.criticalShot(shooter, enemy, random);
                }
                //Hit, but didn't crit - Calculate normal damage
                Damage.calculate(shooter, enemy, 0.4);
            }
        }
        //Check north
        if(enemy.getPath().contains(new Point(point.x, point.y - 1))){
            double chance = random.nextDouble();
            //10 percent for hit
            if(chance >= 0.1){
                Damage.calculate(shooter, enemy, 0.1);
            }
        }
        //Check north-west
        if(enemy.getPath().contains(new Point(point.x - 1, point.y))){
            double chance = random.nextDouble();
            //10 percent for hit
            if(chance >= 0.1){
                Damage.calculate(shooter, enemy, 0.1);
            }
        }
        //Check south-west
        if(enemy.getPath().contains(new Point(point.x - 1, point.y + 1))){
            double chance = random.nextDouble();
            //10 percent for hit
            if(chance >= 0.1){
                Damage.calculate(shooter, enemy, 0.1);
            }
        }
        //Check south
        if(enemy.getPath().contains(new Point(point.x, point.y + 1))){
            double chance = random.nextDouble();
            //10 percent for hit
            if(chance >= 0.1){
                Damage.calculate(shooter, enemy, 0.1);
            }
        }
        //Check south-east
        if(enemy.getPath().contains(new Point(point.x + 1, point.y + 1))){
            double chance = random.nextDouble();
            //10 percent for hit
            if(chance >= 0.1){
                Damage.calculate(shooter, enemy, 0.1);
            }
        }
        //Check north-east
        if(enemy.getPath().contains(new Point(point.x + 1, point.y))){
            double chance = random.nextDouble();
            //10 percent for hit
            if(chance >= 0.1){
                Damage.calculate(shooter, enemy, 0.1);
            }
        }

        return false;
    }
}