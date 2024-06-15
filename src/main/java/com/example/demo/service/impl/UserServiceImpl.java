package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

    // IOC - spring bean life cycle, DI injection

    // DI-- dependency Injection -- setter,constructor,field,dependency injection


    @Override
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }


    @Override
    public User updateUser(User user, Long userId) {

        User user1= userRepository.findById(userId).get();

        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());

        User updatedUser = userRepository.save(user1);

        return updatedUser;
    }

    // 4th Ambadas, 28, I am software Dev.

    @Override
    public User getSingleUser(Long userId) throws Exception {

        userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found on server"));

        return null;

    }


       /* Optional<User> user= userRepository.findById(userId);
        if(user.isPresent()) {
            return user.get();
        }else{
            throw new Exception("Resource not found on server"+ userId);
        }  */


    @Override
    public List<User> getAllUsers() {

        List<User> allUsers = userRepository.findAll();


        return allUsers;
    }

    // 4th Ambadas, 28, I am software Dev.

    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resourse not found on Server" + userId));

        userRepository.delete(user);
    }
}
