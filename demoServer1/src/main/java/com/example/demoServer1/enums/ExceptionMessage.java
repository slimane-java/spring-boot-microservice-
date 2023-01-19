package com.example.demoServer1.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessage {
    Not_FOUND("invoice not found in database"),
    IS_EXISTS("this invoice is already exists");

    private String message;


    @Override
    public String toString() {
        return message;
    }
}
