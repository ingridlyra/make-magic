package com.mkMagic.makeMagic.models.exceptions;

public class NoRecordsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoRecordsException() {
    }

    public NoRecordsException(String message) {
        super(message);
    }
}
