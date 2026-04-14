package com.example.gestionalepizzeria.controller;

import com.example.gestionalepizzeria.model.Ordine;
import com.example.gestionalepizzeria.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordini")
public class OrdineController {

    @Autowired
    private OrdineService ordineService;

    @GetMapping
    public List<Ordine> getAll() {
        return ordineService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordine> getById(@PathVariable Long id) {
        return ordineService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ordine create(@RequestBody Ordine ordine) {
        return ordineService.save(ordine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ordineService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
