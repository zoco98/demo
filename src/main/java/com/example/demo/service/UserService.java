package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import java.util.List;

public interface UserService {

    public List<User> getAllUser();
}
