/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.services.LessorPostService;
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
public class LessorPostController {
    
    @Autowired
    private LessorPostService lessorPostService;

    @RequestMapping("/lessor-post")
    public String postView(Model model, Map<String, String> params) {
        model.addAttribute("lposts", 
                this.lessorPostService.getLessorPosts(params));
        return "lessor-post";
    }
}
