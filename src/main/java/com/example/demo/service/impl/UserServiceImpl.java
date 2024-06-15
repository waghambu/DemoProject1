package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    // IOC - spring bean life cycle, DI injection

    // DI-- dependency Injection -- setter,constructor,field,dependency injection


    @Override
    public User createUser(User user) {
        log.info("Initiating the dao call for the save user data");
        User savedUser = userRepository.save(user);
        log.info("Completed the dao call for the save user data");
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
        log.info("Initiating the dao call for get single user data as userId{}:",userId);
       User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Resource not found on server"));
        log.info("completed the dao call for get single user data as userId{}:",userId);
        return user;

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
