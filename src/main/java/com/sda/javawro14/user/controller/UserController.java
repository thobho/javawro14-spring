package com.sda.javawro14.user.controller;

import com.sda.javawro14.user.service.UserService;
import com.sda.javawro14.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/allUsersPage")
    public String displayAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allStudents", allUsers);
        model.addAttribute("newUser", new User());
        return "allUsersPage";
    }

    @PostMapping("/addUserAction")
    public String addNewUser(@ModelAttribute("newUser") User user, Model model) {
        userService.saveUser(user);
        List<User> updatedUserList = userService.getAllUsers();
        model.addAttribute("allStudents", updatedUserList);
        return "allUsersPage";
    }

}
