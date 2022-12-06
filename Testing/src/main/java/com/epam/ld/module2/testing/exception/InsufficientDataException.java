package com.epam.ld.module2.testing.exception;

public class InsufficientDataException extends RuntimeException {

    public InsufficientDataException(String message, Throwable cause) {
        super(message, cause);
    }

}
