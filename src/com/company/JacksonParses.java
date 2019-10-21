package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class JacksonParses {

    static List<Token> Parse(String str) throws JsonProcessingException {
        List<Token> animalList;
        ObjectMapper objMap = new ObjectMapper();
        animalList = new ArrayList<>(Arrays.asList(objMap.readValue(str, Token[].class)));
        return animalList;
    }
}