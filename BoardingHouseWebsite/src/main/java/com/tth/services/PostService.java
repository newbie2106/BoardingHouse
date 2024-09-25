/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services;

import com.tth.pojo.Post;

/**
 *
 * @author tongh
 */
public interface PostService {

    Post getPostById(int id);
    
    public boolean createPost(Post p);
}
