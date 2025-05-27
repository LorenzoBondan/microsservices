package com.projects.hrexceptionhandler.controllers;

import com.projects.hrexceptionhandler.domain.CustomError;
import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@ConditionalOnClass(FeignException.class)
public class FeignExceptionHandler {

    @ExceptionHandler(FeignException.Unauthorized.class)
    public ResponseEntity<CustomError> handleFeignUnauthorized(FeignException.Unauthorized e, HttpServletRequest request) {
        return ErrorResponseBuilder.buildErrorResponse(e, HttpStatus.UNAUTHORIZED, "Unauthorized from external service", request);
    }

    @ExceptionHandler(FeignException.Forbidden.class)
    public ResponseEntity<CustomError> handleFeignForbidden(FeignException.Forbidden e, HttpServletRequest request) {
        return ErrorResponseBuilder.buildErrorResponse(e, HttpStatus.FORBIDDEN, "Forbidden from external service", request);
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<CustomError> handleFeignNotFound(FeignException.NotFound e, HttpServletRequest request) {
        return ErrorResponseBuilder.buildErrorResponse(e, HttpStatus.NOT_FOUND, "Resource not found (from another service)", request);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<CustomError> handleGenericFeign(FeignException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.resolve(e.status());
        if (status == null) status = HttpStatus.BAD_GATEWAY;

        String message = status.is5xxServerError()
                ? "Server error from external service"
                : "Client error when calling external service";

        return ErrorResponseBuilder.buildErrorResponse(e, status, message, request);
    }
}
