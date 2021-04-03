package com.mkMagic.makeMagic.models.exceptions;

public class HouseNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public HouseNotFoundException() {
    }

    public HouseNotFoundException(String id) {
        super("House not found: " + id);
    }
}
