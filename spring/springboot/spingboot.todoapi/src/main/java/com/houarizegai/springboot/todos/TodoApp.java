package com.houarizegai.springboot.todos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/todos")
public class TodoApp {

    @GetMapping(value = {"", "/"})
    public String listTodos() {
//        Todo todo = new Todo(1, "Java", "This is the desc of java book !");
//        return todo;
        return "helhe";
    }
}
