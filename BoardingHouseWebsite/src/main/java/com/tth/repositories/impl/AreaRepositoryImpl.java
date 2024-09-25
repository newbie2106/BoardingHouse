/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;

import com.tth.pojo.Area;
import com.tth.repositories.AreaRepository;
import java.util.List;
import javax.persistence.Query;
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
public class AreaRepositoryImpl implements AreaRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Area> getArea() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Area.findAll");
        return q.getResultList();
    }

    @Override
    public Area getAreaById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            return session.get(Area.class, id);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
