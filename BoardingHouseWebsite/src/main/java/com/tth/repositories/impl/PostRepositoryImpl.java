/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;

import com.tth.pojo.Post;
import com.tth.repositories.PostRepository;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tongh
 */
@Repository
@Transactional
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Post getPostById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            Post post = session.createQuery("FROM Post p left join fetch p.commentSet WHERE p.id=:id", Post.class)
                    .setParameter("id", id)
                    .getSingleResult();
//            Hibernate.initialize(post.getCommentSet());
            return post;
        } catch (NoResultException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean createPost(Post p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(p);
            return true;
        } catch (NoResultException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
