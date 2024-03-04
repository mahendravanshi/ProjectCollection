package com.security.exception;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String format) {
        super(format);
    }
}
