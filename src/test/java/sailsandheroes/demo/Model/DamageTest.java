package sailsandheroes.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DamageTest {

    @Test
    void calculate() {
        Ship attacker = new Ship();
        Ship victim = new Ship();

        attacker.setWeapon("cannonBall");
        attacker.setFirePower(25);
        //hull life
        victim.setHullQuality(10);
        //10% hit
        Damage.calculate(attacker, victim, 10);
        //TODO MAKE ALL LIFE DOUBLES
        assertEquals(7.5, victim.getHullQuality());

    }

    @Test
    void crit() {
    }

    @Test
    void collision() {
    }
}