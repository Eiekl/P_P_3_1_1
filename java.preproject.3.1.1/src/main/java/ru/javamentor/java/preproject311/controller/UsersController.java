package ru.javamentor.java.preproject311.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.javamentor.java.preproject311.model.User;
import ru.javamentor.java.preproject311.service.UserService;


@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String welcome(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/users")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String editUser (@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("users/{id}")
    public String updateUser (@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String delete (@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
}
