package com.example.SpringSecurity.PasswordEncoder.service;

import com.example.SpringSecurity.CSRF.model.Users;
import com.example.SpringSecurity.CSRF.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    //JWT
    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;
    // end
    public Users register(Users user){
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        } else {
            return "Login Failed";
        }
    }
}
