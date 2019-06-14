package com.sda.javawro14.user.controller;

import com.sda.javawro14.user.dto.CreateUserRestRequest;
import com.sda.javawro14.user.service.UserService;
import com.sda.javawro14.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/testUser")
    public User getTestUser(@RequestParam("name") String userName){
        return new User(userName, new Date());
    }

    @GetMapping("/user")
    public User getUserById(@RequestParam("id") String id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/user")
    public String saveUser(@RequestBody CreateUserRestRequest userCreateRequest){
        return userService.saveUser(userCreateRequest.getName());
    }
}
