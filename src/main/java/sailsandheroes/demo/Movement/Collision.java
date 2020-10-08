package sailsandheroes.demo.Movement;

import sailsandheroes.demo.Model.Ship;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//made by Frederik N
public class Collision {

    public void validateShipsCollisionPath(){

        //Player 1 ship
        Ship ship1 = new Ship();
        ship1.setId(1);
        ship1.setName("player1");
        List<Point> ship1Path = new ArrayList<>();
        ship1Path.add(new Point(1,1));
        ship1Path.add(new Point(2,2));
        ship1Path.add(new Point(3,3));
        ship1Path.add(new Point(4,4));
        ship1.setPath(ship1Path);

        //Player 2 ship
        Ship ship2 = new Ship();
        ship1.setId(2);
        ship2.setName("player2");
        List<Point> ship2Path = new ArrayList<>();
        ship2Path.add(new Point(1,1));
        ship2Path.add(new Point(2,2));
        ship2Path.add(new Point(0,3));
        ship2Path.add(new Point(4,3));
        ship2.setPath(ship2Path);

        for (int i = 0; i < ship1Path.size(); i++) {
            if(ship1.getPath().get(i).equals(ship2.getPath().get(i)))
                System.out.println("Ship collision");
            else
                System.out.println("ship did not collied");
            System.out.println(ship1.getPath().get(i));
            System.out.println(ship2.getPath().get(i));
        }
    }

    public void validateShipsCollisionLastPosition() {
        Ship ship1 = new Ship();
        ship1.setId(1);
        ship1.setName("player1");
        List<Point> ship1Path = new ArrayList<>();
        ship1Path.add(new Point(1,1));
        ship1Path.add(new Point(2,2));
        ship1Path.add(new Point(3,3));
        ship1Path.add(new Point(4,4));
        ship1.setPath(ship1Path);

        //Player 2 ship
        Ship ship2 = new Ship();
        ship1.setId(2);
        ship2.setName("player2");
        List<Point> ship2Path = new ArrayList<>();
        ship2Path.add(new Point(1,1));
        ship2Path.add(new Point(2,2));
        ship2.setPath(ship2Path);

        if(ship1.getPath().get(ship1.getPath().size()-1).equals(ship2.getPath().get(ship2.getPath().size()-1)))
            System.out.println("Ship collision on end position");
        else {
            System.out.println("ship did not collied on end position");
            System.out.println(ship1.getName() + "; " + ship1.getPath().get(ship1.getPath().size() - 1));
            System.out.println(ship2.getName() + "; " + ship2.getPath().get(ship2.getPath().size() - 1));
        }
    }
}
