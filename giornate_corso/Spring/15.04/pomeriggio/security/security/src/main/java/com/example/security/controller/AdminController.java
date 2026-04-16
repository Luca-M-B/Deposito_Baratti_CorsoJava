package com.example.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/pannello")
    public String pannelloAdmin(Authentication auth, Model model) {
        model.addAttribute("user", auth);
        model.addAttribute("isAdminView", true);
        return "dashboard"; // Reuse dashboard for now, or I could create admin.html
    }
}