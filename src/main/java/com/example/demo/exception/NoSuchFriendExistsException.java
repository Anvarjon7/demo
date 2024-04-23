package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class NoSuchFriendExistsException extends RuntimeException{

    public NoSuchFriendExistsException() {}

    public NoSuchFriendExistsException(String message) {
        super(message);
    }

}
