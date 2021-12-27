package com.example.thuchanh1.controller;

import com.example.thuchanh1.entity.User;
import com.example.thuchanh1.service.UserService;
import com.example.thuchanh1.validate.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String displayListUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String displayUserCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult,
                             Model model) {
        UserValidator userValidator = new UserValidator();
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        userService.saveUser(user);
        return "redirect:/list";

    }
}
