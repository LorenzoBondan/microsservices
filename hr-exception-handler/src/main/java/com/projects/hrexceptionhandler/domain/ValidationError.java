package com.projects.hrexceptionhandler.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends CustomError {

    private final List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(LocalDateTime timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public void addError(String fieldName, String message) {
    	errors.removeIf(x -> x.getFieldName().equals(fieldName));
    	errors.add(new FieldMessage(fieldName, message));
    }
}
