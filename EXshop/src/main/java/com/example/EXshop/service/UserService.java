package com.example.EXshop.service;

import com.example.EXshop.models.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User findByUserName(String userName);
}
