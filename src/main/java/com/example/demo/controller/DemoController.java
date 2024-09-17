package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.exception.EmptyRepositoryException;
import com.example.demo.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    /*
     * curl --location 'http://localhost:8080/demo/getLoading'
     */
    @GetMapping("/getLoading")
    public List<User> loadData(){
        List<User> userList = userServiceImpl.getAllUser();
        if(userList.isEmpty() || !(userList.stream().filter(user -> user.getUserId().isEmpty()).toList().isEmpty())){
            throw new EmptyRepositoryException("ER01","No Student/User is registered yet.");
        }
        return userList;
    }
}
