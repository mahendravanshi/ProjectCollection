package com.security.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String format) {
        super(format);
    }
}
