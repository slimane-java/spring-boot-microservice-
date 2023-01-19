package com.example.demoServer1.exception;

public class InvoiceNotFound extends RuntimeException{
    public InvoiceNotFound(String message) {
        super(message);
    }
}
