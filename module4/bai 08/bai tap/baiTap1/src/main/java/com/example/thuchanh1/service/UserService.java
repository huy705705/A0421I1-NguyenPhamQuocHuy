package com.example.thuchanh1.service;

import com.example.thuchanh1.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> findAll();
    public User saveUser(User user);
}
