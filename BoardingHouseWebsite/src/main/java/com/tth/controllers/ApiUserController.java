/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.advice.ValidationException;
import com.tth.components.JwtService;
import com.tth.pojo.Images;
import com.tth.pojo.Lessor;
import com.tth.pojo.Users;
import com.tth.services.ImagesService;
import com.tth.services.LessorService;
import com.tth.services.UserService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tongh
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiUserController {

    @Autowired
    private BCryptPasswordEncoder passswordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private LessorService lessorService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    MessageSource messageSource;
    @Autowired
    private ImagesService imagesService;
    

    @PostMapping(path = "/users/", consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestParam Map<String, String> params, @RequestPart MultipartFile file) {
        Users u = new Users();
        u.setFirstName(params.get("firstName"));
        u.setLastName(params.get("lastName"));
        u.setUsername(params.get("username"));
        u.setPhone(params.get("phone"));
        u.setEmail(params.get("email"));
        u.setAddress(params.get("address"));
        //u.setIsActived(Boolean.parseBoolean(params.get("isActived")));
        u.setIsActived(false);
        String password = params.get("password");
        u.setPassword(passswordEncoder.encode(password));
        u.setRole("ROLE_USER");
        u.setCreatedDate(new Date());
        u.setFile(file);

        this.userService.addUser(u);

    }

    @DeleteMapping("/users/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.userService.deleteUser(id);
    }

    @PostMapping("/login/")
    public ResponseEntity<String> login(@RequestBody Users user) {
        if (this.userService.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("error" + user.getUsername(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> getCurrentUser(Principal p) {
        Users u = this.userService.getUserByUsername(p.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PostMapping(path = "/lessor-register/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void createLessor(@RequestParam Map<String, String> params,
            @RequestPart MultipartFile file,
            @RequestParam List<MultipartFile> images) {
        Users u = new Users();
        u.setFirstName(params.get("firstName"));
        u.setLastName(params.get("lastName"));
        u.setUsername(params.get("username"));
        u.setPhone(params.get("phone"));
        u.setEmail(params.get("email"));
        u.setAddress(params.get("address"));
        //u.setIsActived(Boolean.parseBoolean(params.get("isActived")));
        u.setIsActived(false);
        String password = params.get("password");
        u.setPassword(passswordEncoder.encode(password));
        u.setRole("ROLE_LESSOR");
        u.setCreatedDate(new Date());
        u.setFile(file); // set de avt

        this.userService.addUser(u);
        
        this.lessorService.addLessor(params, images, u);
    }
}
