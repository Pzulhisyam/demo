package com.example.demo.exception;


public class ApiException extends RuntimeException {

    private int code;
    private int statusCode = 400;

    public ApiException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable exception) {
        super(message, exception);
    }

    public ApiException(int value, Throwable exception) {
        super(exception);
        this.code = value;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getCode() {
        return code;
    }
}