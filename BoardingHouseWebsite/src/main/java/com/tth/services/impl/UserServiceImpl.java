/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tth.pojo.Customers;
import com.tth.pojo.Lessor;
import com.tth.pojo.Users;
import com.tth.repositories.CustomerRepository;
import com.tth.repositories.LessorRepository;
import com.tth.repositories.UserRepository;
import com.tth.services.CustomerService;
import com.tth.services.LessorService;
import com.tth.services.UserService;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//
///**
// *
// * @author tongh
// */

@Service("UserDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

//    @Autowired
//    private LessorRepository lessorRepo;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private LessorService lessorService;

    @Override
    public List<Object[]> getUsers() {
        return this.userRepo.getUsers();
    }

    @Override
    public Users getUserByUsername(String username) {
        return this.userRepo.getUserByUsername(username);
    }

    @Override
    public Users getUserById(int id) {
        return this.userRepo.getUserById(id);
    }

    @Override
    public void deleteUser(int id) {
        this.userRepo.deleteUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users u = this.userRepo.getUserByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getRole()));
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.userRepo.authUser(username, password);
    }

    @Override
    public void addUser(Users user) {
        if (!user.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                user.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.userRepo.addUser(user);
        if (user.getRole() == "ROLE_USER") {
            Customers c = new Customers();
            c.setUsers(user);
            c.setId(user.getId());
            this.customerService.addCustomer(c);
        }
    }

    @Override
    public List<Users> GetUserDetails(int id) {
        return this.userRepo.GetUserDetails(id);
    }

}
