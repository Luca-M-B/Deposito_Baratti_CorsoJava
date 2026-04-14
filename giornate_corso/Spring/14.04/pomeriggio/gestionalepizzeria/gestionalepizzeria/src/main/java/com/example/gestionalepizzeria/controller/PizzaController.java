package com.example.gestionalepizzeria.controller;

import com.example.gestionalepizzeria.model.Pizza;
import com.example.gestionalepizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizze")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizza> getAll() {
        return pizzaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getById(@PathVariable Long id) {
        return pizzaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pizza create(@RequestBody Pizza pizza) {
        return pizzaService.save(pizza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pizzaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
