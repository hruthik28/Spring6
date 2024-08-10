package com.example.SpringSecurity.CSRF.repository;

import com.example.SpringSecurity.CSRF.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
