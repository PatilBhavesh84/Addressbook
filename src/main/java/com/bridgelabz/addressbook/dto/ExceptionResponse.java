package com.bridgelabz.addressbook.dto;

public class ExceptionResponse {
    public String message;
    public Object errorObj;

    public ExceptionResponse(String message, Object errorObj) {
        this.message = message;
        this.errorObj = errorObj;
    }
}
