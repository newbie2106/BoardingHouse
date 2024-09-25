/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services;

import com.tth.pojo.LessorPost;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tongh
 */
public interface LessorPostService {

    List<Object[]> getLessorPosts(Map<String, String> params);

    public void deleteLessorPost(int id);

    LessorPost getLessorPostById(int id);

    public LessorPost getPostById(int id);
    
    public boolean createLessorPost(LessorPost lp);

}
