package sailsandheroes.demo.Movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sailsandheroes.demo.Model.Ship;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollisionTest {

    Ship ship1 = new Ship();
    Ship ship2 = new Ship();

    List<Point> ship1Path = new ArrayList<>();
    List<Point> ship2Path = new ArrayList<>();

    @BeforeEach
    public void init() {
        ship1.setId(1);
        ship1Path.add(new Point(1, 1));
        ship1Path.add(new Point(2, 2));
        ship1Path.add(new Point(3, 3));
        ship1Path.add(new Point(4, 4));

        ship2.setId(2);
        ship2Path.add(new Point(1,1));
        ship2Path.add(new Point(2,2));
        ship2Path.add(new Point(3,3));

    }

    @Test
    void validateShipId() {
       assertEquals(1, ship1.getId());
       assertEquals(2, ship2.getId());
    }

    @Test
    void equalsTruevalidateShipsCollisionPath() {

    }

    @Test
    void equalsFalsevalidateShipsCollisionPath() {

    }

    @Test
    void validateShipsCollisionLastPosition() {
        assertEquals(new Point(4,4),ship1Path.get(3));
    }
}