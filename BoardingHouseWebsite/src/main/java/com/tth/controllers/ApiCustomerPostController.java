/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.pojo.CustomerPost;
import com.tth.services.CustomerPostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tongh
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiCustomerPostController {

    @Autowired
    private CustomerPostService customerPostService;

    @GetMapping("/customer-post/")
    public ResponseEntity<List<Object[]>> list(@RequestParam Map<String, String> params) {

        return new ResponseEntity<>(this.customerPostService.getCustomerPosts(params), HttpStatus.OK);
    }

    @DeleteMapping("/customer-post/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLessorPost(@PathVariable(value = "id") int id) {
        this.customerPostService.deleteCustomerPost(id);
    }

    @GetMapping(path = "/customer-post/{customerPostId}/", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerPost> getCustomerPostById(@PathVariable(value = "customerPostId") int id) {
        return new ResponseEntity<>(this.customerPostService.getCustomerPostById(id), HttpStatus.OK);
    }
}
