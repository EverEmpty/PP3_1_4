package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;


    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String adminPage(Model model, Principal principal) {
        model.addAttribute("authUser", userService.getUserByName(principal.getName()));
        model.addAttribute("users", userService.userList());
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", roleService.roleList());
        return "admin";
    }

    @PostMapping("/addNewUser")
    public String saveUser(@ModelAttribute("user")User user, BindingResult result) {

        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user")User user, BindingResult result) {

        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}