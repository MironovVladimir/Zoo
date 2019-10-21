package com.company;

public class Cow extends Herbivorous {

    Cow(String name) {
        super(name);
    }

    Cow(String name, String state) {
        super(name, state);
    }

    @Override
    public String getType() {
        return "Cow";
    }

    @Override
    String getNoise() {
        return "MOOOOOO";
    }
}