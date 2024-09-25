/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tongh
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/users")
    public String user(Model model) {
        model.addAttribute("users", this.userService.getUsers());
        return "user-list";
    }
    
    @GetMapping("/users/{id}")
    public String userView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("users", 
                this.userService.getUserById(id));

        return "user-list";
    }
    
}
