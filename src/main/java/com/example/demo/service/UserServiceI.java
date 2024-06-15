package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserServiceI {

    //curd

    //create

    User createUser(User user);

    //User

    User updateUser(User user,Long UserId);


    //get(single data)
    User getSingleUser(Long userId);

    //get all data

    List<User> getAllUsers();

    // Delete

    void deleteUser(Long userId);
}


