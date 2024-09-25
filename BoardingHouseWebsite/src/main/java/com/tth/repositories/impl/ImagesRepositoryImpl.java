/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;

import com.tth.pojo.Images;
import com.tth.repositories.ImagesRepository;
import org.hibernate.HibernateException;
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
public class ImagesRepositoryImpl implements ImagesRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void addImage(Images image) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            session.save(image);
        }
        catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }
}
