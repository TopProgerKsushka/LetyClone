package com.example.springapp.letyclone.repository;

import com.example.springapp.letyclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
    User findByUsername(String username);
    boolean existsByUsername(String username);

}
