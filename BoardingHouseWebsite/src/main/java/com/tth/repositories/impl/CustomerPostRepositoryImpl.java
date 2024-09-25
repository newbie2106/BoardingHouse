/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;

import com.tth.pojo.CustomerPost;
import com.tth.pojo.Customers;
import com.tth.pojo.Post;
import com.tth.pojo.Users;
import com.tth.repositories.CustomerPostRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class CustomerPostRepositoryImpl implements CustomerPostRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> getCustomerPosts(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rCP = q.from(CustomerPost.class);
        Root rP = q.from(Post.class);
        Root rC = q.from(Customers.class);
        Root rU = q.from(Users.class);
        q.multiselect(rP.get("id"), rP.get("title"), rP.get("description"),
                rCP.get("address"), rU.get("firstName"), rU.get("lastName"),
                rU.get("avatar"), rP.get("createdDate"));

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rCP.get("customerId"), rC.get("id")));
        predicates.add(b.equal(rU.get("id"), rC.get("id")));
        predicates.add(b.equal(rP.get("id"), rCP.get("id")));

        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public CustomerPost getCustomerPostById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(CustomerPost.class, id);
    }
    
    @Override
    public void deleteCustomerPost(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        CustomerPost p = this.getCustomerPostById(id);
        s.delete(p);
    }

}
