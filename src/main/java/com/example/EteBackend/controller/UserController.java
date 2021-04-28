package com.example.EteBackend.controller;

import com.example.EteBackend.model.UserDetails;
import com.example.EteBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

@Autowired
private UserService userService;
@RequestMapping(value="users/signup", method= RequestMethod.POST)
public String registerUser(UserDetails user){
    userService.registerUser(user);
    return "details";
}
}


