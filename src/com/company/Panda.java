package com.company;



public class Panda extends Herbivorous{
    static private String type = "Panda";
    static private String noise = "-____-";

    Panda(String name){
        super(name);
    }

    @Override
    public int scream() {
        state = SCREAMING;
        System.out.println(type + " " + name + ": " + noise);
        return state;
    }

    Panda(String name, String type){
        super(name,type);
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
