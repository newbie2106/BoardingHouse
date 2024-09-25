/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services;

import com.tth.pojo.Users;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;
//
///**
// *
// * @author tongh
// *

public interface UserService extends UserDetailsService {

    public void deleteUser(int id);

    Users getUserById(int id);

    List<Users> GetUserDetails(int id);

    Users getUserByUsername(String username);

    List<Object[]> getUsers();

    public boolean authUser(String username, String password);

    //Users addUser(Map<String, String> params, MultipartFile avatar);

    void addUser(Users user);
}
