package com.company;

public abstract class Herbivorous implements Living{

    int state;
    static final int CAGE = 2;
    static final int IDLE = 3;
    static final int SLEEPING = 4;
    final static int SCREAMING = 5;
    String name;

    Herbivorous(String name, String state){
        if(state.equals("SLEEPING")) this.state = Herbivorous.SLEEPING;
        else if(state.equals("SCREAMING")) this.state = Herbivorous.SCREAMING;
        else this.state = Herbivorous.IDLE;
        this.name = name;
    }

    Herbivorous(String name){
        this.name = name;
        this.state = Herbivorous.IDLE;
    }

    private int eat() {
        state = IDLE;
        return state;
    }

    private int sleep() {
        state = SLEEPING;
        return state;
    }

    abstract protected int scream();

    public int reactOn(boolean predatorsScream, boolean herbivorousScream, boolean storm, int supervisor, boolean isNight, int food) {
        if(food==CAGE) this.eat();
        else if(storm||(supervisor==CAGE)||(state == SCREAMING)) return this.scream();
        else if(isNight) this.sleep();
        else this.state = IDLE;
        return this.state;
    }
}