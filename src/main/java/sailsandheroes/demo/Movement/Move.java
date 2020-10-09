package sailsandheroes.demo.Movement;

import sailsandheroes.demo.Enums.TurnResult;
import sailsandheroes.demo.Model.Board;
import sailsandheroes.demo.Model.Hex;
import sailsandheroes.demo.Model.Player;
import sailsandheroes.demo.Model.Ship;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Move {

    private final Board hexboard = new Board();
    private Hex startHex;
    private final Map<String, Integer> directions = new HashMap<>();
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

    public String validMove(Ship myShip, Point p) {
        String direction = myShip.getDirection();

        if (startHex.getNeighbor(direction).getPosition().equals(p.getLocation())) {
            return direction;
        }

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
        if (startHex.getNeighbor(turnleft).getPosition().equals(p.getLocation())) {
            direction = turnleft;
            return direction;
        } else if (startHex.getNeighbor(turnright).getPosition().equals(p.getLocation())) {
            direction = turnright;
            return direction;
        } else {
            System.out.println("Ship " + myShip.getId() + " cannot go to field " + p.getLocation() + " from position " + startHex.getPosition());
        }
        return "false";
    }

    public boolean moveShip(Ship myShip) {

        findStartingHex(myShip);

        for (Point p : myShip.getPath()) {
            String direction = validMove(myShip, p);
            if (!(direction.equals("false"))) {
                myShip.setDirection(direction);
            }
            if (direction.equals("false")) {
                return false;
            }

            switch (direction) {
                case "N":
                    if (startHex.getN().getPosition().equals(p)) {
                        startHex = findHexFromPoint(p);
                        System.out.println("You've successfully moved north");
                    }
                    else System.out.println("You cannot sail north");
                    break;
                case "S":
                    if (startHex.getS().getPosition().equals(p)) {
                        startHex = findHexFromPoint(p);
                        System.out.println("You've successfully moved south");
                    }
                    else System.out.println("You cannot sail south");
                    break;
                case "NW":
                    if (startHex.getnW().getPosition().equals(p)) {
                        startHex = findHexFromPoint(p);
                        System.out.println("You've successfully moved northwest");
                    }
                    else System.out.println("You cannot sail northwest");
                    break;
                case "NE":
                    if (startHex.getnE().getPosition().equals(p)) {
                        startHex = findHexFromPoint(p);
                        System.out.println("You've successfully moved northeast");
                    }
                    else System.out.println("You cannot sail northeast");
                    break;
                case "SW":
                    if (startHex.getsW().getPosition().equals(p)) {
                        startHex = findHexFromPoint(p);
                        System.out.println("You've successfully moved southwest");
                    }
                    else System.out.println("You cannot sail southwest");
                    break;
                case "SE":
                    if (startHex.getsE().getPosition().equals(p)) {
                        System.out.println("You've successfully moved southeast");
                        startHex = findHexFromPoint(p);
                    }
                    else {
                        System.out.println("You cannot sail southeast");
                    }
                    break;
            }
        }
        myShip.setPosition(startHex.getPosition());
        return true;
    }

    public void findStartingHex(Ship myShip) {
        for (Hex hex : hexboard.getHexGrid()) {
            if (hex.getPosition().x == myShip.getPosition().x && hex.getPosition().y == myShip.getPosition().y) {
                startHex = hex;
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
