/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;

import com.tth.pojo.Images;
import com.tth.pojo.Lessor;
import com.tth.pojo.Users;
import com.tth.repositories.LessorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class LessorRepositoryImpl implements LessorRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Lessor getLessorById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Lessor.class, id);
    }

    @Override
    public List<Object[]> GetUnapprovedUsers() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rL = q.from(Lessor.class);
        Root rU = q.from(Users.class);

        q.multiselect(rL.get("id"), rU.get("username"), rU.get("firstName"),
                rU.get("lastName"), rU.get("createdDate"), rU.get("avatar"));

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rU.get("isActived"), Boolean.parseBoolean("0")));
        predicates.add(b.equal(rL.get("id"), rU.get("id")));

        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Lessor> GetLessorDetails(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Lessor> q = b.createQuery(Lessor.class);
        Root rL = q.from(Lessor.class);

        q.select(rL).distinct(true);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rL.get("id"), id));

        q.where(predicates.toArray(Predicate[]::new));
        Query query = s.createQuery(q);
        return query.getResultList();

    }

    @Override
    public List<Images> GetLessorImages(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Images> q = b.createQuery(Images.class);
        Root rI = q.from(Images.class);
        
        q.select(rI).distinct(true);

        List<Predicate> predicates = new ArrayList<>();
        
        predicates.add(b.equal(rI.get("lessorId"), id));

        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);

        return query.getResultList();
    }
    
    @Override
    public boolean addLessor(Lessor lessor) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            session.save(lessor);
            return true;
        }
        catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public void approveUser(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Lessor l = this.getLessorById(id);
        l.getUsers().setIsActived(Boolean.TRUE);
        s.update(l);
    }

    @Override
    public void deleteLessor(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Lessor l = this.getLessorById(id);
        s.delete(l);
    }

}
