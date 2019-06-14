package com.sda.javawro14.user.controller;

import com.sda.javawro14.user.service.UserService;
import com.sda.javawro14.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
        setUpModel(model);
        return "allUsersPage";
    }

    @PostMapping("/addUserAction")
    public RedirectView addNewUser(@ModelAttribute("newUser") User user, Model model) {
        userService.saveUser(user);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allUsersPage");
        return redirectView;
    }

    @DeleteMapping("/deleteUserAction/{deletedUserId}")
    public RedirectView deleteUserAction(@PathVariable String deletedUserId, Model model) {
        userService.deleteUserById(deletedUserId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allUsersPage");
        return redirectView;
    }

    private void setUpModel(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allStudents", allUsers);
        model.addAttribute("newUser", new User());
        model.addAttribute("deletedUserId", "");
    }

}
