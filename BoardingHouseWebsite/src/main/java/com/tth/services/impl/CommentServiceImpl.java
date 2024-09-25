/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services.impl;

import com.tth.pojo.Comment;
import com.tth.pojo.Post;
import com.tth.pojo.Users;
import com.tth.repositories.CommentRepository;
import com.tth.repositories.PostRepository;
import com.tth.repositories.UserRepository;
import com.tth.services.CommentService;
import java.security.Principal;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tongh
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment addComment(Map<String, String> params, Principal user) {
        try {
            Comment comment = new Comment();
            String content = params.get("content");
            int postId = Integer.parseInt(params.get("postId"));
            Users u = userRepository.getUserByUsername(user.getName());
            Post p = postRepository.getPostById(postId);

            comment.setContent(content);
            comment.setPostId(p);
            comment.setUserId(u);
            comment.setCreateDate(new Date());
            commentRepository.addComment(comment);
            return comment;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
