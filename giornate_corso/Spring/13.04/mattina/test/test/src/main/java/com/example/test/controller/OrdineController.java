package com.example.test.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.service.OrdineService;

@RestController
public class OrdineController {

    private final OrdineService ordineService;

    public OrdineController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @PostMapping("/ordina")
    public String ordina() {
        ordineService.creaOrdine();
        return "Ordine effettuato.";
    }

    @PostMapping("/ordina2")
    public String ordina(@RequestBody String testo) {
        ordineService.creaOrdine();
        return "testo body " + testo;
    }

}