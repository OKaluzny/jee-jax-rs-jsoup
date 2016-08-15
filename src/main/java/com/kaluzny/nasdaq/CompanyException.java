package com.kaluzny.nasdaq;

public class CompanyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CompanyException(String message, Throwable cause) {
        super(message, cause);
    }
}