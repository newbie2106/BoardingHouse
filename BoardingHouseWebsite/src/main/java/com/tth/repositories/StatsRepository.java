/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories;

import com.tth.pojo.Users;
import java.util.List;

/**
 *
 * @author tongh
 */
public interface StatsRepository {

    List<Object[]> StatsUserByPeriod(int year, String period);

    List<Object[]> StatsUserByDay(int year, int month);
//    List<Users> StatsUserByYear();
//
//    List<Users> StatsUserByPeriod();

}
