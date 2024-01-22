package com.example.demo.exception;

public class ResourceNotFoundException extends ApiException {

    public ResourceNotFoundException(Class clazz, Object id) {
        super(clazz.getSimpleName() + "( " + id + " ) Not found ", 404);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}