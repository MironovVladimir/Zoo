package com.company;

public class Wolf extends Predator{

    static private String type = "Wolf";
    static private String noise = "awooo";

    Wolf(String name, String state){
        super(name, state);
    }

    Wolf(String name){
        super(name);
    }

    public int scream() {
        state = SCREAMING;
        System.out.println(type + " " + name + ": " + noise);
        return state;
    }

    public String getType() {
        return type;
    }

    public String getState(){
        if(state==IDLE) return "IDLE";
        else if(state==SLEEPING) return "SLEEPING";
        else if(state == SCREAMING) return "SCREAMING";
        return "IDLE";
    }

    public String getName(){
        return name;
    }
}