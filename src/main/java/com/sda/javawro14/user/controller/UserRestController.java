package com.sda.javawro14.user.controller;

import com.sda.javawro14.user.dto.CreateUserRestRequest;
import com.sda.javawro14.user.model.UserDTO;
import com.sda.javawro14.user.service.UserService;
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

//    @RequestMapping("/testUser")
//    public UserDTO getTestUser(@RequestParam("name") String userName){
//        return new UserDTO(userName, new Date());
//    }

    @GetMapping("/user")
    public UserDTO getUserById(@RequestParam("id") String id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/user")
    public String saveUser(@RequestBody CreateUserRestRequest userCreateRequest){
        return userService.saveUser(userCreateRequest.getName());
    }
}
