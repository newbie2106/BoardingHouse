/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services;

import com.tth.pojo.CustomerPost;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tongh
 */
public interface CustomerPostService {

    List<Object[]> getCustomerPosts(Map<String, String> params);

    public void deleteCustomerPost(int id);

    CustomerPost getCustomerPostById(int id);

}
