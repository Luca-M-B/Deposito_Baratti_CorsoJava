package com.example.todolist.repository;

import com.example.todolist.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    // estendendo CrudRepository si importa tutte le operazioni crud
}