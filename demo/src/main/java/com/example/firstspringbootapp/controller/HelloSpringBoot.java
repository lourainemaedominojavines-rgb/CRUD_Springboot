package com.example.firstspringbootapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
@RequestMapping("/api/main")
public class HelloSpringBoot {

    @GetMapping("/print")
    public String print() {
        return "Hello, Louraine Mae Javines!";
    }

}
