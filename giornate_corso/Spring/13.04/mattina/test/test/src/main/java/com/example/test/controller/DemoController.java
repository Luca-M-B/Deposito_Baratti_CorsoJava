package com.example.test.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.test.service.MessaggioService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {

    private final MessaggioService messaggioservice;

    public DemoController(MessaggioService messaggioservice) {
        this.messaggioservice = messaggioservice;
    }

    @GetMapping("/saluta")
    public String getMethodName() {
        return new String();
    }

    public String saluta() {
        messaggioservice.saluta();
        return "Saluto inviato";
    }

}
