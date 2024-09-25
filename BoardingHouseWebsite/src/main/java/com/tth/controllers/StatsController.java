/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.services.StatsService;
import java.time.LocalDate;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tongh
 */
@Controller
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/stats")
    public String stats(Model model, @RequestParam Map<String, String> params) {

        String month = params.getOrDefault("month", String.valueOf(LocalDate.now().getMonthValue()));
        String period = params.getOrDefault("period", "MONTH");
        String year = params.getOrDefault("year", String.valueOf(LocalDate.now().getYear()));
        model.addAttribute("statsUserByPeriod",
                this.statsService.StatsUserByPeriod(Integer.parseInt(year), period));
         model.addAttribute("statsUserByDay",
                this.statsService.StatsUserByDay(Integer.parseInt(year),
                        Integer.parseInt(month)));

        return "stats";
    }
}
