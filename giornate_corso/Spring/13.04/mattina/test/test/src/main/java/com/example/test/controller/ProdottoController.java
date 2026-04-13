package com.example.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.test.model.Prodotto;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {

    private List<Prodotto> prodotti = new ArrayList<>();
    private Long idCounter = 1L;

    @GetMapping
    public List<Prodotto> getAll() {
        return prodotti;
    }

    @PostMapping
    public Prodotto crea(@RequestBody Prodotto nuovo) {
        nuovo.setId(idCounter++);
        prodotti.add(nuovo);
        return nuovo;
    }

}