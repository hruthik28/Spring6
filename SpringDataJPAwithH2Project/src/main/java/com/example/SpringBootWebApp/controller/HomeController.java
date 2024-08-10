package com.example.SpringBootWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet(){
        return "welcome page";
    }

    @RequestMapping("/about")
    public String about(){
        return "about page";
    }
}
