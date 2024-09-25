/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services.impl;

import com.tth.pojo.Customers;
import com.tth.pojo.Follow;
import com.tth.pojo.Lessor;
import com.tth.repositories.FollowRepository;
import com.tth.repositories.LessorRepository;
import com.tth.repositories.UserRepository;
import com.tth.services.FollowService;
import java.security.Principal;
import java.util.List;
import java.util.UUID;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tongh
 */

@Service
public class FollowServiceImpl implements FollowService{
    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LessorRepository landLordRepository;
    
    @Override
    public Follow addFollow(int lessorId, Principal user) {
        int count = 1;
        try {
            Follow follow = new Follow();
            String username = user.getName();
            Customers customer = userRepository.getUserByUsername(username).getCustomers();
            Lessor lessor = landLordRepository.getLessorById(lessorId);
            follow.setLessorId(lessor);
            follow.setCustomerId(customer);
            this.followRepository.addFollow(follow);
            return follow;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean deleteFollow(int lessorId, int customerId) {
        return followRepository.deleteFollow(lessorId,customerId);
    }

    @Override
    public List<Customers> getFollowerByLessorId(int id) {
        return this.followRepository.getFollowerByLessorId(id);
    }
    
}
