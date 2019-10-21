package com.company;

public class Fox extends Predator {
    Fox(String name) {
        super(name);
    }

    Fox(String name, String state) {
        super(name, state);
    }

    @Override
    public String getType() {
        return "Fox";
    }

    @Override
    String getNoise() {
        return "Ururuuu";
    }
}