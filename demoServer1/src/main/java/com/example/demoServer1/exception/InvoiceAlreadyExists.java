package com.example.demoServer1.exception;

public class InvoiceAlreadyExists extends RuntimeException{
    public InvoiceAlreadyExists(String message) {
        super(message);
    }
}
