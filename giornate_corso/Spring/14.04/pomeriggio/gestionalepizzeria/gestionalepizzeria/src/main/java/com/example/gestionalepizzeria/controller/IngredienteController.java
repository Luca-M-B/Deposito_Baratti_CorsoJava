package com.example.gestionalepizzeria.controller;

import com.example.gestionalepizzeria.model.Ingrediente;
import com.example.gestionalepizzeria.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredienti")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public List<Ingrediente> getAll() {
        return ingredienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> getById(@PathVariable Long id) {
        return ingredienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ingrediente create(@RequestBody Ingrediente ingrediente) {
        return ingredienteService.save(ingrediente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ingredienteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
