package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/public/hello")
    public String salutoPubblico() {
        return "home";
    }
}