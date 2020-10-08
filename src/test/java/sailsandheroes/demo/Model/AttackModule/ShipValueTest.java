package sailsandheroes.demo.Model.AttackModule;

import org.junit.jupiter.api.Test;
import sailsandheroes.demo.Model.Ship;

import static org.junit.jupiter.api.Assertions.*;

class ShipValueTest {
    @Test
    void testingShip() {
        Ship ship = new Ship(1, "William", "Front", 160, 66, 240, 120, 4, "front", "dansk","balls");
        ship.calculatePowerValue();
        assertEquals(33,ship.getPowerValue());
    }
}