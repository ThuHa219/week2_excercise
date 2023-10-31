package com.example.exception;

public class OutOfSharingException extends RuntimeException {

    public OutOfSharingException(String message) {
        super(message);
    }
}
