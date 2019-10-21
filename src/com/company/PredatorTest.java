package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class PredatorTest {

    @Test
    public void reactOn() {
    Wolf a =new Wolf("Tony");
    int c = a.reactOn(false, false,true, 0
    , false, 0);
    assertEquals(c, Predator.SCREAMING);
    assertEquals(a.getCurrentState(), Predator.SCREAMING);
    }
}