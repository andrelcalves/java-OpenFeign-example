package com.andrelcalves.OpenFeignExample.application.controller;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super("Could not find client " , new RuntimeException());
    }
}
