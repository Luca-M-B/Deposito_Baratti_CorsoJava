package com.example.todolistautenticazione.todo;

import com.example.todolistautenticazione.user.Utente;
import com.example.todolistautenticazione.user.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final UtenteRepository utenteRepository;

    @GetMapping
    public List<Todo> getAllTodo(Authentication authentication) {
        String username = authentication.getName();
        return todoService.findByUtenteUsername(username);
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id, Authentication authentication) {
        Todo todo = todoService.findById(id);
        verifyOwnership(todo, authentication.getName());
        return todo;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo, Authentication authentication) {
        String username = authentication.getName();
        Utente utente = utenteRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato"));
        todo.setUtente(utente);
        return todoService.save(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo modificato, Authentication authentication) {
        Todo esistente = todoService.findById(id);
        verifyOwnership(esistente, authentication.getName());

        esistente.setNome(modificato.getNome());
        esistente.setDescrizione(modificato.getDescrizione());
        esistente.setCompletato(modificato.isCompletato());
        return todoService.save(esistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id, Authentication authentication) {
        Todo todo = todoService.findById(id);
        verifyOwnership(todo, authentication.getName());
        todoService.delete(id);
        return ResponseEntity.ok("ToDo eliminato");
    }

    private void verifyOwnership(Todo todo, String username) {
        if (!todo.getUtente().getUsername().equals(username)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Non hai i permessi per accedere a questo ToDo");
        }
    }
}