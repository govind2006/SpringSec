package com.example.SpringSecEx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringSecEx.model.Users;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
    
    // Additional
    
}


