package com.company;


//Отдельный интерфейс, предназначенный для того чтобы выделить методы, необходимые для работы с классом Zoo("проживания" в нем)

public interface Living {

    int reactOn(boolean predatorsScream, boolean herbivorousScream, boolean storm, int supervisor, boolean isNight, int food);
    String getName();
    int getCurrentState();
    String getStrState();
    String getType();

}