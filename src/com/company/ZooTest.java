package com.company;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ZooTest {

    @Test
    public void zooTest() throws IOException {
        Zoo test = new Zoo("zooTable.txt");
        test.add(new Cow("Louis"));
        test.add(new Cow("Angie"));
        test.add(new Cow("Говрюша"));
        test.add(new Wolf("Серый"));
        assertFalse(test.predatorsNoise);
        assertFalse(test.herbivorousNoise);

        //если надзиратель приходит кормить хищники начинают шуметь
        test.sendSupervisorTo(Predator.CAGE);
        assertTrue(test.predatorsNoise);
        assertFalse(test.herbivorousNoise);

        //Как только уходит надзиратель животные начинают есть и прекращают шуметь
        test.listen();
        assertFalse(test.predatorsNoise);
        assertFalse(test.herbivorousNoise);

        //Травоядные реагируют на надзирателя аналогично хищникам
        test.sendSupervisorTo(Herbivorous.CAGE);
        assertTrue(test.herbivorousNoise);
        assertFalse(test.predatorsNoise);

        //Как только хищники слышат шум травоядных - они начинают шуметь
        test.listen();
        assertTrue(test.predatorsNoise);
        assertFalse(test.herbivorousNoise);

        test.sendSupervisorTo(Predator.CAGE);
        test.listen();
        assertFalse(test.herbivorousNoise&&test.predatorsNoise);

        test.makeNight(true);
        test.makeStorm(true);
        test.listen();
        test.makeStorm(false);
        assertTrue(test.herbivorousNoise&&test.predatorsNoise);

        test.sendSupervisorTo(Herbivorous.CAGE);
        test.sendSupervisorTo(Predator.CAGE);
        assertFalse(test.herbivorousNoise&&test.predatorsNoise);
        test.listen();
        test.listen();
        test.makeNight(false);
        test.listen();
        assertFalse(test.herbivorousNoise&&test.predatorsNoise);

        test.loadTo("data.txt");

    }

}