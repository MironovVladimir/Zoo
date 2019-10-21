package com.company;

public abstract class Predator extends Animal{
    final static int CAGE = 1;
    final static int IDLE = 0;
    final static int SLEEPING = 1;
    final static int SCREAMING = 2;

    Predator(String name) {
        super(name);
    }

    Predator(String name, String state) {
        super(name, state);
    }

    @Override
    public boolean isPredator() {
        return true;
    }

    @Override
    public int getIntState(String state) {
        switch (state) {
            case "Idle" : return 0;
            case "Sleeping" : return 1;
            case "Screaming" : return 2;
        }
        return 3;
    }

    @Override
    public int reactOn(boolean predatorsScream, boolean herbivorousScream, boolean storm, int supervisor, boolean isNight, int food) {
        if(food==1) this.eat();
        else if(herbivorousScream||storm||(supervisor==1)||(getCurrentState()==getIntState("Screaming"))) return this.scream();
        else if(isNight) this.sleep();
        else setCurrentState(getIntState("Idle"));
        return currentState;
    }

}