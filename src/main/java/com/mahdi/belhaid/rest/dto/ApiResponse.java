package com.mahdi.belhaid.rest.dto;

public class ApiResponse<T> {

    private final T data;
    private final ErrorResponse errorMessage;


    public ApiResponse(T data, ErrorResponse errorMessage) {
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public ApiResponse(T data){
        this(data,null);
    }

    public ApiResponse(ErrorResponse errorMessage){
        this(null,errorMessage);
    }

    public T getData() {
        return data;
    }

    public ErrorResponse getErrorMessage() {
        return errorMessage;
    }


    @Override
    public String toString() {
        return "ApiResponse{" +
                "data=" + data +
                ", errorMessage=" + errorMessage +
                '}';
    }
    public boolean hasError(){
        return errorMessage!=null;
    }
}
