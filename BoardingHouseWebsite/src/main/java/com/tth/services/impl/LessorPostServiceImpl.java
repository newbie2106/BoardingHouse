/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services.impl;

import com.tth.pojo.LessorPost;
import com.tth.repositories.LessorPostRepository;
import com.tth.services.LessorPostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tongh
 */
@Service
public class LessorPostServiceImpl implements LessorPostService {

    @Autowired
    private LessorPostRepository lessorPostRepo;

    @Override
    public List<Object[]> getLessorPosts(Map<String, String> params) {
        return this.lessorPostRepo.getLessorPosts(params);
    }

    @Override
    public void deleteLessorPost(int id) {
        this.lessorPostRepo.deleteLessorPost(id);
    }

    @Override
    public LessorPost getLessorPostById(int id) {
        return this.lessorPostRepo.getLessorPostById(id);
    }

    @Override
    public LessorPost getPostById(int id) {
        return this.lessorPostRepo.getPostById(id);
    }

    @Override
    public boolean createLessorPost(LessorPost lp) {
        return this.lessorPostRepo.createLessorPost(lp);
    }
}
