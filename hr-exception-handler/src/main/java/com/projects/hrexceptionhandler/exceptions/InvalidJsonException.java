package com.projects.hrexceptionhandler.exceptions;

public class InvalidJsonException extends RuntimeException {

    private final String fieldName;

    public InvalidJsonException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
