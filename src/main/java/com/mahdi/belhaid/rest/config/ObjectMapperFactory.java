package com.mahdi.belhaid.rest.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {

    private ObjectMapperFactory(){}
    private static volatile ObjectMapper instance = null;

    public static ObjectMapper getInstance() {
        if (instance == null) {
            synchronized (ObjectMapperFactory.class){
                if(instance == null){
                    instance = new ObjectMapper();
                }
            }
        }
        return instance;
    }

}
