/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services.impl;

import com.tth.pojo.CustomerPost;
import com.tth.repositories.CustomerPostRepository;
import com.tth.services.CustomerPostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tongh
 */
@Service
public class CustomerPostServiceImpl implements CustomerPostService {

    @Autowired
    private CustomerPostRepository customerPostRepo;

    @Override
    public List<Object[]> getCustomerPosts(Map<String, String> params) {
        return this.customerPostRepo.getCustomerPosts(params);
    }

    @Override
    public CustomerPost getCustomerPostById(int id) {
        return this.customerPostRepo.getCustomerPostById(id);
    }

    @Override
    public void deleteCustomerPost(int id) {
        this.customerPostRepo.deleteCustomerPost(id);
    }

}
