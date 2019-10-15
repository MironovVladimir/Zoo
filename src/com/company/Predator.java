package com.company;

public abstract class Predator implements Living{

    int state;
    final static int CAGE = 1;
    final static int IDLE = 0;
    final static int SLEEPING = 1;
    final static int SCREAMING = 2;
    String name;

    Predator(String name, String state){
        if(state.equals("SLEEPING")) this.state = Predator.SLEEPING;
        else if(state.equals("SCREAMING")) this.state = Predator.SCREAMING;
        else this.state = Predator.IDLE;
        this.name = name;
    }

    Predator(String name){
        this.name = name;
        this.state = Predator.IDLE;
    }

    private int eat() {
        state = IDLE;
        return state;
    }

    private int sleep() {
        state = SLEEPING;
        return state;
    }

    abstract public int scream();

    public int reactOn(boolean predatorsScream, boolean herbivorousScream, boolean storm, int supervisor, boolean isNight, int food) {
        if(food==CAGE) this.eat();
        else if(herbivorousScream||storm||(supervisor==CAGE)||(state==SCREAMING)) return this.scream();
        else if(isNight) this.sleep();
        else state = IDLE;
        return this.state;
    }
}