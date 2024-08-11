package com.example.SpringSecurity.PasswordEncoder;

import com.example.SpringSecurity.CSRF.model.Users;
import com.example.SpringSecurity.CSRF.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    public Users register(Users user){
        return userRepo.save(user);
    }
}
