package com.company;

public abstract class Herbivorous extends Animal {
    static final int CAGE = 2;
    static final int IDLE = 3;
    static final int SLEEPING = 4;
    final static int SCREAMING = 5;

    Herbivorous(String name) {
        super(name);
    }

    Herbivorous(String name, String state) {
        super(name, state);
    }

    @Override
    public boolean isPredator() {
        return false;
    }

    @Override
    public int getIntState(String state) {
        switch (state) {
            case "Idle" : return 3;
            case "Sleeping" : return 4;
            case "Screaming" : return 5;
        }
        return 3;
    }

    @Override
    public int reactOn(boolean predatorsScream, boolean herbivorousScream, boolean storm, int supervisor, boolean isNight, int food) {
        if(food==2) this.eat();
        else if(storm||(supervisor==2)||(currentState == getIntState("Screaming"))) return this.scream();
        else if(isNight) this.sleep();
        else currentState = getIntState("Idle");
        return currentState;
    }
}