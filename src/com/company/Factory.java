package com.company;

import java.lang.reflect.InvocationTargetException;

class Factory {

    Living create(Token t) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Living> clazz = (Class<Living>) Class.forName("com.company."+t.type);
        return (Living) clazz.getDeclaredConstructor(String.class, String.class).newInstance(t.name, t.state);
    }
}