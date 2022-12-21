package com.ex.kata312.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ex.kata312.model.User;
import com.ex.kata312.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", new User());
        return "users/allUsers";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id")int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "users/editUser";
    }

    @PostMapping
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        User temp = userService.getUserById(user.getId());
        if (temp == null) {
            return "redirect:/users";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id")int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
