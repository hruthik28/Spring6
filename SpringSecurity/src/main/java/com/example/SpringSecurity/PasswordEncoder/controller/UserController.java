package com.example.SpringSecurity.PasswordEncoder.controller;

import com.example.SpringSecurity.CSRF.model.Users;
import com.example.SpringSecurity.PasswordEncoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    // BCryptPasswordEncoder in inbuilt in spring security and strength is the number of rounds the plain text will hash to (i.e, 2 to the power of strength defined),
    // this can range between 4 to 31

    //Passwords stored in DB as plain text will now not work with any of the requests as with the Bcrypt we will be looking ofr has of the password and not plain text

    @PostMapping("/register")
    public Users register (@RequestBody Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }
}
