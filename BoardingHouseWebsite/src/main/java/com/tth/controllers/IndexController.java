/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.pojo.Users;
import com.tth.services.AreaService;
import com.tth.services.CustomerPostService;
import com.tth.services.LessorPostService;
import com.tth.services.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tongh
 */
@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private LessorPostService lessorPostService;

    @Autowired
    private CustomerPostService customerPostService;

    @RequestMapping("/")
    public String index(Model model, Map<String, String> params) {
        model.addAttribute("lposts",
                this.lessorPostService.getLessorPosts(params));
        model.addAttribute("cposts",
                this.customerPostService.getCustomerPosts(params));

        return "index";
    }

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("areas", this.areaService.getArea());
    }
    
}
