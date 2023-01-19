package com.example.demoServer1.api;

import com.example.demoServer1.exception.ErrorMessage;
import com.example.demoServer1.exception.InvoiceAlreadyExists;
import com.example.demoServer1.exception.InvoiceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ApiException {

    @ExceptionHandler(InvoiceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage invoiceNotFound(InvoiceNotFound invoiceNotFound) {
        return new ErrorMessage(HttpStatus.NO_CONTENT.value(), invoiceNotFound.getMessage(), new Date(), "check the id client and the id order is correct");
    }

    @ExceptionHandler(InvoiceAlreadyExists.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage invoiceAlreadyExists(InvoiceAlreadyExists invoiceAlreadyExists) {
        return new ErrorMessage(HttpStatus.FOUND.value(), invoiceAlreadyExists.getMessage(), new Date(), "invoice exist");
    }
}
