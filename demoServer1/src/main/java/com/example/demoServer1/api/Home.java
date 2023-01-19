package com.example.demoServer1.api;

import com.example.demoServer1.exception.InvoiceAlreadyExists;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class Home {
    @GetMapping("/test")
    public String create() throws InvoiceAlreadyExists {

        return "Api create";
    }
}
