package com.example.SpringSecurity.CSRF.service;

import com.example.SpringSecurity.CSRF.model.UserPrincipal;
import com.example.SpringSecurity.CSRF.model.Users;
import com.example.SpringSecurity.CSRF.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepo.findByUsername(username);
        if (null == user) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("404 User not found");
        }
        return new UserPrincipal(user);
    }
}
