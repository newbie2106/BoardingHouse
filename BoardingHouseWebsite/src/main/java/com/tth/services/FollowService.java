/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services;

import com.tth.pojo.Customers;
import com.tth.pojo.Follow;
import java.security.Principal;
import java.util.List;

/**
 *
 * @author tongh
 */
public interface FollowService {

    Follow addFollow(int lessorId, Principal user);

    boolean deleteFollow(int lessorId, int customerId);

    List<Customers> getFollowerByLessorId(int id);

}
