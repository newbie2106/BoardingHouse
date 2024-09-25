/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;

import com.tth.pojo.Users;
import com.tth.repositories.StatsRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.eclipse.persistence.jpa.jpql.parser.TrimExpression.Specification;
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
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

//    private SimpleDateFormat f;
    @Override
    public List<Object[]> StatsUserByPeriod(int year, String period) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rU = q.from(Users.class);

        q.multiselect(b.function(period, Integer.class, rU.get("createdDate")),
                b.count(rU.get("id")));

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(b.function("YEAR", Integer.class, rU.get("createdDate")), year));
        predicates.add(b.notEqual(rU.get("role"), "ROLE_ADMIN"));
        
        q.where(predicates.toArray(Predicate[]::new));
        q.groupBy(b.function(period, Integer.class, rU.get("createdDate")));
        q.orderBy(b.asc(b.function(period, Integer.class, rU.get("createdDate"))));

        Query query = s.createQuery(q);
        return query.getResultList();
    }

//    @Override
//    public List<Object[]> StatsUserByYear() {
//        return null;
//    }
//
//    @Override
//    public List<Object[]> StatsUserByPeriod() {
//        return null;
//    }
    @Override
    public List<Object[]> StatsUserByDay(int year, int month) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rU = q.from(Users.class);

        q.multiselect(b.function("day", Integer.class, rU.get("createdDate")),
                b.count(rU.get("id")));

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(b.function("YEAR", Integer.class, rU.get("createdDate")), year));
        predicates.add(b.equal(b.function("MONTH", Integer.class, rU.get("createdDate")), month));
        predicates.add(b.notEqual(rU.get("role"), "ROLE_ADMIN"));

        q.where(predicates.toArray(Predicate[]::new));
        q.groupBy(b.function("day", Integer.class, rU.get("createdDate")));
        q.orderBy(b.asc(b.function("day", Integer.class, rU.get("createdDate"))));

        Query query = s.createQuery(q);
        return query.getResultList();
    }
}
