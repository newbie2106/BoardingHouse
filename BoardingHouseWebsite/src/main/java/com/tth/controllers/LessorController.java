/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.services.LessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tongh
 */
@Controller
public class LessorController {

    @Autowired
    private LessorService lessorService;

    // Lây tt de xuat len web
    @RequestMapping("/approve-user")
    public String Lessor(Model model) {
        model.addAttribute("lessors", this.lessorService.GetUnapprovedUsers());

        return "lessor-list";
    }

    @GetMapping("/approve-user/{id}")
    public String lessorViewDetails(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("lessors",
                this.lessorService.getLessorById(id));
        
        model.addAttribute("lessorDetails", this.lessorService.GetLessorDetails(id));
        model.addAttribute("lessorImages", this.lessorService.GetLessorImages(id));

        return "lessor-list-details";
    }

}
