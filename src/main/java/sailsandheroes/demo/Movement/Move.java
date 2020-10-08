package sailsandheroes.demo.Movement;

import sailsandheroes.demo.Model.Board;
import sailsandheroes.demo.Model.Hex;
import sailsandheroes.demo.Model.Ship;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Move {

    private Board hexboard = new Board();
    private Map<String, Integer> directions = new HashMap<>();
    {
        hexboard.fillBoard(6, 12);
        directions.put("N", 1);
        directions.put("NE", 2);
        directions.put("SE", 3);
        directions.put("S", 4);
        directions.put("SW", 5);
        directions.put("NW", 6);
    }



    public Move() {

    }

    public void moveShip() {
        List<Point> myPoints = new ArrayList<>();
        myPoints.add(new Point(2,2));
        myPoints.add(new Point(3,2));
        myPoints.add(new Point(4,3));
        myPoints.add(new Point(5,2));

        /*Board hexboard = new Board();
        hexboard.fillBoard(6,12);*/

        Ship myShip = new Ship();
        myShip.setId(1);
        myShip.setStartPos(new Point(1, 1));
        myShip.setSpeed(5);
        myShip.setDirection("SE");
        myShip.setPath(myPoints);

        Hex starthex = null;

        for (Hex hex : hexboard.getHexGrid()) {
            if (hex.getPosition().x == myShip.getStartPos().x && hex.getPosition().y == myShip.getStartPos().y) {
                starthex = hex;
            }
        }

        String direction = myShip.getDirection();
        for (Point p : myShip.getPath()) {
            if (!(starthex.getNeighbor(direction).getPosition().equals(p.getLocation()))) {
                int dirval = directions.get(direction);
                int turnLeftVal = dirval - 1;
                int turnRightVal = dirval + 1;
                if (turnLeftVal == 0) {
                    turnLeftVal = 6;
                }
                if (turnRightVal == 7) {
                    turnRightVal = 1;
                }

                String turnleft = getKeyByValue(turnLeftVal);
                String turnright = getKeyByValue(turnRightVal);
                if (starthex.getNeighbor(turnleft).getPosition().equals(p.getLocation())) {
                    direction = turnleft;
                    System.out.println("Turning left");
                }
                else if (starthex.getNeighbor(turnright).getPosition().equals(p.getLocation())) {
                    direction = turnright;
                    System.out.println("Turning right");
                }
                else {
                    System.out.println("Ship cannot go to field");
                    return;
                }
            }


            switch (direction) {
                case "N":
                    if (starthex.getN().getPosition().equals(p)) {
                        starthex.setPosition(p);
                        System.out.println("You've successfully moved north");
                    }
                    else System.out.println("You cannot sail here");
                break;
                case "S":
                    if (starthex.getS().getPosition().equals(p)) {
                        starthex.setPosition(p);
                        System.out.println("You've successfully moved south");
                    }
                    else System.out.println("You cannot sail here");
                break;
                case "NW":
                    if (starthex.getnW().getPosition().equals(p)) {
                        starthex.setPosition(p);
                        System.out.println("You've successfully moved northwest");
                    }
                    else System.out.println("You cannot sail here");
                break;
                case "NE":
                    if (starthex.getnE().getPosition().equals(p)) {
                        starthex.setPosition(p);
                        System.out.println("You've successfully moved northeast");
                    }
                    else System.out.println("You cannot sail here");
                break;
                case "SW":
                    if (starthex.getsW().getPosition().equals(p)) {
                        starthex.setPosition(p);
                        System.out.println("You've successfully moved southwest");
                    }
                    else System.out.println("You cannot sail here");
                break;
                case "SE":
                    if (starthex.getsE().getPosition().equals(p)) {
                        System.out.println("You've successfully moved southeast");
                        System.out.println("From position: " + starthex.getPosition().x + ", " + starthex.getPosition().y);
                        System.out.println("To position: " + p.x + ", " + p.y);
                        starthex = findHexFromPoint(p);
                    }
                    else {
                        System.out.println("You cannot sail southeast");
                        System.out.println("From position: " + starthex.getPosition().x + ", " + starthex.getPosition().y);
                        System.out.println("To position: " + p.x + ", " + p.y);
                        System.out.println("Southeast from here is: " + starthex.getsE().getPosition().x + ", " + starthex.getsE().getPosition().y);
                    }
                break;
            }
        }
    }

    public Hex findHexFromPoint(Point p) {
        for (Hex hex : hexboard.getHexGrid()) {
            if (hex.getPosition().x == p.x && hex.getPosition().y == p.y) {
                return hex;
            }
        }
        System.out.println("Couldn't find hex with these coords.");
        return new Hex();
    }

    public String getKeyByValue(int value) {
        for (Map.Entry<String, Integer> entry : directions.entrySet()) {
            if (value == entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
    }
}
