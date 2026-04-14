package com.example.toDoList.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.toDoList.model.ToDo;
import com.example.toDoList.service.ToDoService;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getAll() {
        return toDoService.getAll();
    }

    @PostMapping
    public ResponseEntity<ToDo> aggiungiToDo(@Validated @RequestBody ToDo nuovoToDo) {
        ToDo creato = toDoService.create(nuovoToDo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getById(@PathVariable Long id) {
        return toDoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> aggiorna(@PathVariable Long id, @RequestBody ToDo modificato) {
        return toDoService.update(id, modificato)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> elimina(@PathVariable Long id) {
        if (toDoService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
