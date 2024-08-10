package com.example.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {

//    better to use if laptop is not implementing any interface
//    @Autowired // requires
//    private Laptop laptop; // field injection

//    if laptop implements interface computer then should refer to computer
//    as autowire will look for type computer and laptop is also a type of computer as it implements computer
    @Autowired // requires
    private Computer comp; // field injection

//    public Dev(Laptop laptop){ // constructor injection, doe not require autowire but will not throw error if used
//        this.laptop = laptop;
//    }
//
//    @Autowired // requires
//    public void setLaptop(Laptop laptop){ // setter injection
//        this.laptop = laptop;
//    }

    public void build(){
        System.out.println("build");
    }
}
