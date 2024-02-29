package com.security.service;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String format) {
        super(format);
    }
}
