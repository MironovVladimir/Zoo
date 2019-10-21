package com.company;

public abstract class Animal implements Living {

    int currentState;
    String name;

    abstract public String getType();
    abstract String getNoise();

    abstract boolean isPredator();
    abstract int getIntState(String state);


    Animal(String name){
        this.name = name;
    }

    Animal(String name, String state){
        if(state.equals("SLEEPING")) setCurrentState(getIntState("Sleeping"));
        else if(state.equals("SCREAMING")) setCurrentState(getIntState("Screaming"));
        else setCurrentState(getIntState("Idle"));
        this.name = name;
    }


    public String getName(){
        return name;
    }

    public int getCurrentState(){
        return currentState;
    }
    void setCurrentState(int CurrentState){
        this.currentState = CurrentState;
    }
    int scream(){
        System.out.println(getType()+" "+getName()+": "+ getNoise());
        setCurrentState(getIntState("Screaming"));
        return currentState;
    }

    public String getStrState(){
        if(currentState==getIntState("Idle")) return "IDLE";
        else if(currentState==getIntState("Sleeping")) return "SLEEPING";
        else if(currentState==getIntState("Screaming")) return "SCREAMING";
        return "IDLE";
    }

    int eat(){
        currentState = getIntState("Idle");
        return currentState;
    }
    int sleep(){
        currentState = getIntState("Sleeping");
        return currentState;
    }

    @Override
    public abstract int reactOn(boolean predatorsScream, boolean herbivorousScream, boolean storm, int supervisor, boolean isNight, int food);
}