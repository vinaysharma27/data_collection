package com.example.EteBackend.service;


import com.example.EteBackend.model.UserDetails;
import com.example.EteBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
    UserRepository userRepository;

    public void registerUser(UserDetails newUser){
        userRepository.register(newUser);
    }
}


