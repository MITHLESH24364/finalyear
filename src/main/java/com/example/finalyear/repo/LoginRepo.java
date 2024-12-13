package com.example.finalyear.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalyear.entity.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {

    Login findByUsername(String username);

}
