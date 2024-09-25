/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services.impl;

import com.tth.pojo.Area;
import com.tth.repositories.AreaRepository;
import com.tth.services.AreaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tongh
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepo;

    
    @Override
    public List<Area> getArea() {
        return this.areaRepo.getArea();
    }

    @Override
    public Area getAreaById(int id) {
        return this.areaRepo.getAreaById(id);
    }

}
