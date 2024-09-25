/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.pojo.Follow;
import com.tth.services.FollowService;
import com.tth.services.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tongh
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiFollowController {
    @Autowired
    private FollowService followService;
    @Autowired
    private UserService userService;

    @PostMapping("/follow/{lessorId}/")
    public ResponseEntity addFollow(@PathVariable(value = "lessorId") int lessorId, Principal user){
        Follow follow = followService.addFollow(lessorId, user);
        if (follow != null)
            return new ResponseEntity(follow, HttpStatus.CREATED);
        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/follow/{lessorId}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFollow(@PathVariable(value = "lessorId") int lessorId, Principal user) {
        int customerId = this.userService.getUserByUsername(user.getName()).getCustomers().getId();
        this.followService.deleteFollow(lessorId, customerId);
    }
}
