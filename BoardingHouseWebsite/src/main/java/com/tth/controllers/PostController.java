/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.services.CustomerPostService;
import com.tth.services.LessorPostService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

///**
// *
// * @author tongh
// */
@Controller
public class PostController {

    @Autowired
    private LessorPostService lessorPostService;
    
    @Autowired
    private CustomerPostService customerPostService;

    @RequestMapping("/post")
    public String postView(Model model, Map<String, String> params) {
        model.addAttribute("lposts",
                this.lessorPostService.getLessorPosts(params));
        model.addAttribute("cposts", this.customerPostService.getCustomerPosts(params));
        return "post";
    }

}
//    @GetMapping("/post/{bhId}")
//    public String updateProductView(Model model, @PathVariable(value = "bhId") int id) {
//        model.addAttribute("posts", this.postService.getPostById(id));
//
//        return "post";
//    }

