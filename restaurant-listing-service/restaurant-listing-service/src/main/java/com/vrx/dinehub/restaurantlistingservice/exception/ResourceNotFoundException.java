package com.vrx.dinehub.restaurantlistingservice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
