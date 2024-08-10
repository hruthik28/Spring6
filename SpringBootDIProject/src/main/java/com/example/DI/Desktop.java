package com.example.DI;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // will set it as the priority
public class Desktop implements Computer{

    public void compile(){
        System.out.println("compile with desktop");
    }
}
