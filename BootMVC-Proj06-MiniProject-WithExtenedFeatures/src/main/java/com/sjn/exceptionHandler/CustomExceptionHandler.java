package com.sjn.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        // Retrieve field errors from the BindingResult
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String customErrorMessage = getCustomErrorMessage(fieldError);
            errorMessage.append(customErrorMessage).append("; ");
        }

        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST, "Bad Request", errorMessage.toString());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    private String getCustomErrorMessage(FieldError fieldError) {
        String field = fieldError.getField();
        String defaultMessage = fieldError.getDefaultMessage();

        // Customize the error message based on the field
        if ("firstName".equals(field)) {
            return "Custom error message for firstName field";
        } else if ("lastName".equals(field)) {
            return "Custom error message for lastName field";
        }

        // Return the default error message if no customization is needed
        return defaultMessage;
    }
}
