package com.company;

public class Fox extends Predator{
    private static String type = "Fox";
    private static String noise = "Uruuuuu";

    Fox(String name, String state){
        super(name, state);
    }

    Fox(String name){
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
