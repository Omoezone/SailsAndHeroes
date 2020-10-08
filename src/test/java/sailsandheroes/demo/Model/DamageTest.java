package sailsandheroes.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DamageTest {

    @Test
    void calculate() {
       /* Ship attacker = new Ship();
        Ship victim = new Ship();

        attacker.setWeapon("cannonBall");
        attacker.setFirePower(25);
        //hull life
        victim.setHullQuality(10);
        //10% hit
        Damage.calculate(attacker, victim, 10);
        //TODO MAKE ALL LIFE DOUBLES
        assertEquals(7.5, victim.getHullQuality());
*/
    }

    @Test // Lavet af William
    void criticalShot() {
        Ship attacker = new Ship(1, "William", "Front", 160, 66, 240, 120, 4, "front", "dansk","Grape Shot");
        Ship defender = new Ship(2, "JohnWick", "Front", 160, 66, 240, 120, 4, "front", "dansk","Cannon Ball");
        // Tests that it can kill 50% and 25% of sailors
        assertEquals(120,defender.getAmountOfSailors()/2);
        assertEquals(180,(defender.getAmountOfSailors()-defender.getAmountOfSailors()/4));
        // Test that it can substracts the life of sails correctly
        defender.setSailQuality(0);
        assertEquals(0,defender.getSailQuality());
        defender.setSailQuality(111);
        assertEquals(37, defender.getSailQuality()/3);

    }

    @Test
    void collision() {
    }
}