/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;

import com.tth.pojo.Users;
import com.tth.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tongh
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public Users getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Users WHERE username = :username");
        q.setParameter("username", username);

        return (Users) q.getSingleResult();
    }

    @Override
    public Boolean authUser(String username, String password) {
        Users u = this.getUserByUsername(username);
        return this.passEncoder.matches(password, u.getPassword());

    }

    @Override
    public List<Object[]> getUsers() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rU = q.from(Users.class);

        q.multiselect(rU.get("avatar"), rU.get("username"), rU.get("firstName"), rU.get("lastName"),
                rU.get("createdDate"), rU.get("role"), rU.get("id"));

        List<Predicate> predicates = new ArrayList<>();


        //q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public Users getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Users.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Users u = this.getUserById(id);
        s.delete(u);
    }

    @Override
    public Users addUser(Users user) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(user);
            return user;
        }
        catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }



    @Override
    public List<Users> GetUserDetails(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Users> q = b.createQuery(Users.class);
        Root rL = q.from(Users.class);
        
        q.select(rL);

        List<Predicate> predicates = new ArrayList<>();
        
        predicates.add(b.equal(rL.get("id"), id));

        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

}
