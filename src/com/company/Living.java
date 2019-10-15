package com.company;

public interface Living {
    int reactOn(boolean predatorsScream, boolean herbivorousScream, boolean storm, int supervisor, boolean isNight, int food);
    String getName();
    String getState();
    String getType();
}
