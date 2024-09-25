/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories;

import com.tth.pojo.Users;
import java.util.List;

/**
 *
 * @author tongh
 */
public interface UserRepository {

    public void deleteUser(int id);

    Users getUserById(int id);

    List<Users> GetUserDetails(int id);

    Users getUserByUsername(String username);

    List<Object[]> getUsers();

    public Boolean authUser(String username, String password);

    public Users addUser(Users user);
}
