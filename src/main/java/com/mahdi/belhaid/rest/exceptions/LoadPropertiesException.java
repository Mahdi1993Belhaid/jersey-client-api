package com.mahdi.belhaid.rest.exceptions;

public class LoadPropertiesException extends RuntimeException{

    public LoadPropertiesException(String message){
        super(message);
    }

    public LoadPropertiesException(Throwable error){
       super(error);
    }
    public LoadPropertiesException(String message,Throwable error){
       super(message,error);
    }
}
