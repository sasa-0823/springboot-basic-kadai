package com.example.spring_kadai_todo.conttoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring_kadai_todo.entity.ToDo;
import com.example.spring_kadai_todo.service.ToDoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ToDoController {
  private final ToDoService todoService;

  public ToDoController(ToDoService todoService){
    this.todoService = todoService;
  }

  @GetMapping("/")
  public String todo(Model model){
    List<ToDo> todos = todoService.getAlltodos();
    model.addAttribute("todos", todos);
    return "ToDoView";
  }

  @PostMapping("/register")
  public String registerTodo(RedirectAttributes redirectAttributes,
  @RequestParam("todo_title") String todoTitle,
  @RequestParam("todo_priority") String todoPriority,
  @RequestParam("todo_status") String todoStatus){
    try{
      todoService.createTodo(todoTitle, todoPriority, todoStatus);
      redirectAttributes.addFlashAttribute("successMessage", "todoを登録しました");
    }catch(IllegalArgumentException e){
      redirectAttributes.addFlashAttribute("failureMessage", e.getMessage());
      redirectAttributes.addFlashAttribute("todoPriority", todoPriority);
      redirectAttributes.addFlashAttribute("todoStatus", todoStatus);
    }
    return "redirect:/";
  }
  
}
