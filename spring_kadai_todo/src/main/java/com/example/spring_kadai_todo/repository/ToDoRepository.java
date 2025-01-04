package com.example.spring_kadai_todo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_kadai_todo.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
  List<ToDo> findByTodoTitle(String todoTitle);
}
