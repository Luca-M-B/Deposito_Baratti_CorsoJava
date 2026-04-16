package com.example.todolistautenticazione.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUtenteId(Long utenteId);
    List<Todo> findByUtenteUsername(String username);
}