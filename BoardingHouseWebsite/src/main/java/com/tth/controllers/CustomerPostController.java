/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.services.CustomerPostService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tongh
 */
@Controller
public class CustomerPostController {

    @Autowired
    private CustomerPostService customerPostService;

    @RequestMapping("/customer-post")
    public String customerPostView(Model model, Map<String, String> params) {
        model.addAttribute("cposts", this.customerPostService.getCustomerPosts(params));
        return "customer-post";
    }
}
