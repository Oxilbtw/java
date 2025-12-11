package com.example.order.processing;

public class GenericProcessingException extends RuntimeException {
    public GenericProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
