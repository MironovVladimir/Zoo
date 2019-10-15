package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class LivingTest {

    @Test
    public void reactOn() {
        Living test = new Wolf("John");
        int a = test.reactOn(false, false,false,0,true, 0);
        assertEquals(a, Predator.SLEEPING);
        a = test.reactOn(false,false,true, 0, true, 0);
        assertEquals(a, Predator.SCREAMING);
        a = test.reactOn(true,false, false,0,true, 0);
        assertEquals(a, Predator.SCREAMING);
        a = test.reactOn(true, false,false, 0, true, Predator.CAGE);
        assertEquals(a, Predator.IDLE);
        a = test.reactOn(false,false, false,0, true,0);
        assertEquals(a, Predator.SLEEPING);
        a = test.reactOn(false,false,false,0,false,0);
        assertEquals(a, Predator.IDLE);
        a = test.reactOn(false, true, false, 0, false, 0);
        assertEquals(a, Predator.SCREAMING);
        a = test.reactOn(true,false,false,0,false,0);
        assertEquals(a, Predator.SCREAMING);
        a = test.reactOn(true, false,false,Predator.CAGE, false, 0);
        assertEquals(a, Predator.SCREAMING);
        a = test.reactOn(true, false,false,0, false,Predator.CAGE);
        assertEquals(a, Predator.IDLE);
        a = test.reactOn(false, false,false,0,true,0);
        assertEquals(a, Predator.SLEEPING);
        a = test.reactOn(false,false, true,0,true,0);
        assertEquals(a, Predator.SCREAMING);
        a = test.reactOn(false,false, false, 0, true,0);
        assertEquals(a, Predator.SCREAMING);
        a = test.reactOn(false,false, false, 0, true,Predator.CAGE);
        assertEquals(a, Predator.IDLE);

    }
}