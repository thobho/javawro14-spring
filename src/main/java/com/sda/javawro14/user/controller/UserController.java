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
        model.addAttribute("queryString", new QueryString());
        return "allUsersPage";
    }

    @PostMapping("/addUserAction")
    public String addNewUser(@ModelAttribute("newUser") UserDTO userDTO, Model model) {
        userService.saveUser(userDTO);
        List<UserDTO> updatedUserDTOList = userService.getAllUsers();
        model.addAttribute("allStudents", updatedUserDTOList);
        return "redirect:/allUsersPage";
    }

    @PostMapping("/searchUserAction")
    public String searchUserByName(@ModelAttribute("queryString") QueryString queryString, Model model){
        List<UserDTO> foundUsers = userService.findByQueryString(queryString.getQueryString());

        model.addAttribute("allStudents", foundUsers);
        model.addAttribute("newUser", new UserDTO());
        model.addAttribute("queryString", new QueryString());

        return "allUsersPage";
    }

    public static class QueryString{
        String queryString;

        public QueryString() {
        }

        public QueryString(String queryString) {
            this.queryString = queryString;
        }

        public String getQueryString() {
            return queryString;
        }

        public void setQueryString(String queryString) {
            this.queryString = queryString;
        }
    }

}
