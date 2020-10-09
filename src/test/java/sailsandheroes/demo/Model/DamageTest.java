package sailsandheroes.demo.Model;

import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class DamageTest {

    @Test //Lavet af Benjamin
    void calculate() {
        Ship attacker = new Ship();
        Ship victim = new Ship();
        attacker.setPowerValue(25);
        victim.setHullQuality(10);
        victim.setAmountOfSailors(10);
        victim.setSailQuality(100);

        //hull
        attacker.setAmmunition("Cannon Ball");
        //10%
        Damage.calculate(attacker, victim, 0.1);
        assertEquals(7.5, victim.getHullQuality());
        //40%
        victim.setHullQuality(10);
        Damage.calculate(attacker, victim, 0.4);
        assertEquals(0, victim.getHullQuality());


        //sail
        attacker.setAmmunition("Chain Shot");
        //10%
        Damage.calculate(attacker, victim, 0.1);
        assertEquals(97.5, victim.getSailQuality());
        //40%
        victim.setSailQuality(100);
        Damage.calculate(attacker, victim, 0.4);
        assertEquals(90, victim.getSailQuality());

        //sailors
        attacker.setAmmunition("Grape Shot");
        //10%
        Damage.calculate(attacker, victim, 0.1);
        assertEquals(7, victim.getAmountOfSailors());
        //40%
        //test that it converts double to int
        victim.setAmountOfSailors(100);
        attacker.setPowerValue(26);
        Damage.calculate(attacker, victim, 0.4);
        assertEquals(89, victim.getAmountOfSailors());
    }

    @Test // Lavet af William
    void criticalShot() {
        Ship attacker = new Ship(1, "William", new Point(1, 1), 160.0, 66, 1, 240, 120.0, 4, "front", "dansk","Grape Shot");
        Ship defender = new Ship(2, "JohnWick", new Point(9, 3), 160.0, 66, 1, 240, 120.0, 4, "front", "dansk","Cannon Ball");
        // Tests that it can kill 50% and 25% of sailors
        assertEquals(120,defender.getAmountOfSailors()/2);
        assertEquals(180,(defender.getAmountOfSailors()-defender.getAmountOfSailors()/4));
        // Test that it can substracts the life of sails correctly
        defender.setSailQuality(0);
        assertEquals(0,defender.getSailQuality());
        defender.setSailQuality(120);
        assertEquals(80, defender.getSailQuality()- defender.getSailQuality()/3);

    }

    @Test
    void collision() {
    }
}