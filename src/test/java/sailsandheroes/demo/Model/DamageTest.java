package sailsandheroes.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DamageTest {

    @Test
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

    @Test
    void crit() {
    }

    @Test
    void collision() {
    }
}