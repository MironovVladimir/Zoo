package com.company;

public class Wolf extends Predator {

    Wolf(String name) {
        super(name);
    }

    Wolf(String name, String state) {
        super(name, state);
    }

    @Override
    public String getType() {
        return "Wolf";
    }

    @Override
    String getNoise() {
        return "AWOOOOOO";
    }
}