/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;

import com.tth.pojo.Customers;
import com.tth.pojo.Follow;
import com.tth.repositories.FollowRepository;
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
public class FollowRepositoryImpl implements FollowRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addFollow(Follow follow) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            session.save(follow);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteFollow(int lessorId, int customerId) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            Query query = session.createQuery("DELETE FROM Follow f WHERE f.lessorId.id=:lessorId AND f.customerId.id=:customerId");
            query.setParameter("lessorId", lessorId);
            query.setParameter("customerId", customerId);
            return query.executeUpdate() > 0;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Customers> getFollowerByLessorId(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            Query query = session.createQuery("SELECT f.tenantId FROM Follow f WHERE f.landLordId.id =: id");
            query.setParameter("id", id);
            return query.getResultList();
        }
        catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
