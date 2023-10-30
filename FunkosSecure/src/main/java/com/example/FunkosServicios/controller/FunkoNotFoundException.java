package com.example.FunkosServicios.controller;

public class FunkoNotFoundException extends RuntimeException {
    public FunkoNotFoundException(String message) {
        super(message);
    }
}
