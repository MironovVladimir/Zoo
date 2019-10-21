package com.company;

public class Panda extends Herbivorous {
    Panda(String name) {
        super(name);
    }

    Panda(String name, String state) {
        super(name, state);
    }

    @Override
    public String getType() {
        return "Panda";
    }

    @Override
    String getNoise() {
        return "*______*";
    }
}