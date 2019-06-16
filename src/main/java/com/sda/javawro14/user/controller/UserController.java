package com.sda.javawro14.user.controller;

import com.sda.javawro14.user.model.UserDTO;
import com.sda.javawro14.user.service.UserService;
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
        List<UserDTO> allUserDTOS = userService.getAllUsers();
        model.addAttribute("allStudents", allUserDTOS);
        model.addAttribute("newUser", new UserDTO());
        model.addAttribute("queryString", "");
        return "allUsersPage";
    }

    @PostMapping("/addUserAction")
    public String addNewUser(@ModelAttribute("newUser") UserDTO userDTO, Model model) {
        userService.saveUser(userDTO);
        List<UserDTO> updatedUserDTOList = userService.getAllUsers();
        model.addAttribute("allStudents", updatedUserDTOList);
        return "redirect:/allUsersPage";
    }

    @GetMapping("/searchUserAction")
    public String searchUserByName(String queryString, Model model){
        List<UserDTO> foundUsers = userService.findByQueryString(queryString);

        model.addAttribute("allStudents", foundUsers);
        model.addAttribute("newUser", new UserDTO());
        model.addAttribute("queryString", "");

        return "allUsersPage";
    }
}
