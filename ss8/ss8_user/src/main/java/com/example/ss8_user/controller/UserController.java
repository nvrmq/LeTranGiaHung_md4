package com.example.ss8_user.controller;

import com.example.ss8_user.model.User;
import com.example.ss8_user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @PostMapping("/submit")
    public String submit(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "home";
        } else {
            userService.addUser(user);
            return "result";
        }
    }
}
