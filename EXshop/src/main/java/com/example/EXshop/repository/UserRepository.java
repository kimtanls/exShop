package com.example.EXshop.repository;

import com.example.EXshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
