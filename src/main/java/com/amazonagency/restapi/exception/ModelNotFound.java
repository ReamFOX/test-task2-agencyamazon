package com.amazonagency.restapi.exception;

public class ModelNotFound extends RuntimeException {
    public ModelNotFound(String message) {
        super(message);
    }
}
