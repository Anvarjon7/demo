package com.example.demo.exception;

public class UserAlreadyExistsException extends Exception {

    String message;

    public UserAlreadyExistsException() {}

    public UserAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
