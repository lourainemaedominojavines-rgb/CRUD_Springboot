package com.example.firstspringbootapp.exception;

public class NameNotFoundException extends RuntimeException {
    public NameNotFoundException(String message) {
        super(message);
    }
}