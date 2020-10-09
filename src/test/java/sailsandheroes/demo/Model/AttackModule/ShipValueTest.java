package sailsandheroes.demo.Model.AttackModule;

import org.junit.jupiter.api.Test;
import sailsandheroes.demo.Model.Ship;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ShipValueTest {
// Lavet af William
    @Test
    void testingShip() {
        // Calculate PowerValue for the ship
        Ship ship = new Ship(1, "William", new Point(1,1), 160.0, 66, 240, 120.0, 4, "front", "dansk","Cannon Balls");
        ship.calculatePowerValue();
        assertEquals(33,ship.getPowerValue());
    }
}