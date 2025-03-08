package com.mahdi.belhaid.rest.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {

    private ObjectMapperFactory(){}
    private static ObjectMapper instance = null;

    public static ObjectMapper getInstance() {
        if (instance == null) {
            instance = new ObjectMapper();
        }
        return new ObjectMapper();
    }

}
