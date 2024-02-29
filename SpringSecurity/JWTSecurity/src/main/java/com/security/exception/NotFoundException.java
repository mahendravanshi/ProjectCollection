package com.security.service;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String format) {
        super(format);
    }
}
