package com.mahdi.belhaid.rest.dto;

public class ApiResponse<T> {

    private T data;
    private ErrorResponse errorMessage;


    public ApiResponse() {
    }

    public ApiResponse(T data, ErrorResponse errorMessage) {
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorResponse getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorResponse errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ApiResponse (ErrorResponse errorMessage){
        this.errorMessage = errorMessage;
    }

    public  ApiResponse(T data){
        this.data = data;
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
