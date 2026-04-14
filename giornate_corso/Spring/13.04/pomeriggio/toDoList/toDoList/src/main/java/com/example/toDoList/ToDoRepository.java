package com.example.toDoList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.toDoList.model.ToDo;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

}
