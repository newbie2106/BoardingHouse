/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories;

import com.tth.pojo.Post;

/**
 *
 * @author tongh
 */
public interface PostRepository {

    Post getPostById(int id);

    boolean createPost(Post p);

}
