package com.example.spring_kadai_todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring_kadai_todo.entity.ToDo;
import com.example.spring_kadai_todo.repository.ToDoRepository;

@Service
public class ToDoService {
  private final ToDoRepository todoRepository;
  
  public ToDoService(ToDoRepository todoRepository){
    this.todoRepository = todoRepository;
  }

  // todo追加
  public void createTodo(String todoTitle, String todoPriority, String todoStatus){
    if(todoTitle == null || todoTitle.isEmpty()){
      throw new IllegalArgumentException("todoタイトルを入力してください");
    }

    ToDo todo = new ToDo();
    todo.setTodoTitle(todoTitle);
    todo.setTodoPriority(todoPriority);
    todo.setTodoStatus(todoStatus);

    todoRepository.save(todo);
  }

  
  public List<ToDo> getAlltodos(){
    return todoRepository.findAll();
  }

}
