package sailsandheroes.demo.Model.AttackModule;

import sailsandheroes.demo.Model.Damage;
import sailsandheroes.demo.Model.Ship;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class CheckHit {                                             //TODO WILL THE SHOT POINT BE A HEX OR A POINT?
    public static boolean checkHit(ArrayList<Point> path, Ship ship, /*Hex hex*/Point point){
        Random random = new Random();

        //TODO WHAT IF ENEMY DOESN'T MOVE? THE LIST WOULD BE EMPTY NO?
        //Check center
        if(path.contains(new Point(point.x, point.y))){
            int chance = random.nextInt(100) + 1;
            //40 percent for hit
            if(chance >= 40){
                chance = random.nextInt(20) + 1;
                if(chance >= 2){
                    Damage.crit(chance);
                }
                //TODO Was crit here or in damage?
                //Call damage class
                Damage.calculate();
            }
        }
        //Check north
        if(path.contains(new Point(point.x, point.y - 1))){
            int chance = random.nextInt(100) + 1;
            //10 percent for hit
            if(chance >= 10){
                Damage.calculate();
            }
        }
        //Check north-west
        if(path.contains(new Point(point.x - 1, point.y))){
            int chance = random.nextInt(100) + 1;
            //10 percent for hit
            if(chance >= 10){
                Damage.calculate();
            }
        }
        //Check south-west
        if(path.contains(new Point(point.x - 1, point.y + 1))){
            int chance = random.nextInt(100) + 1;
            //10 percent for hit
            if(chance >= 10){
                Damage.calculate();
            }
        }
        //Check south
        if(path.contains(new Point(point.x, point.y + 1))){
            int chance = random.nextInt(100) + 1;
            //10 percent for hit
            if(chance >= 10){
                Damage.calculate();
            }
        }
        //Check south-east
        if(path.contains(new Point(point.x + 1, point.y + 1))){
            int chance = random.nextInt(100) + 1;
            //10 percent for hit
            if(chance >= 10){
                Damage.calculate();
            }
        }
        //Check north-east
        if(path.contains(new Point(point.x + 1, point.y))){
            int chance = random.nextInt(100) + 1;
            //10 percent for hit
            if(chance >= 10){
                Damage.calculate();
            }
        }
        return false;
    }
}
