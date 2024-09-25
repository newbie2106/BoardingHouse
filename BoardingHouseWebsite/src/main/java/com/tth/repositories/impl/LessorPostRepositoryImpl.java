/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;

import com.tth.pojo.Area;
import com.tth.pojo.Images;
import com.tth.pojo.Lessor;
import com.tth.pojo.LessorPost;
import com.tth.pojo.Post;
import com.tth.pojo.Users;
import com.tth.repositories.LessorPostRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
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
public class LessorPostRepositoryImpl implements LessorPostRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> getLessorPosts(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rLP = q.from(LessorPost.class);
        Root rP = q.from(Post.class);
        Root rA = q.from(Area.class);
        //Root rPI = q.from(PostImages.class);
        Root rI = q.from(Images.class);
        Root rL = q.from(Lessor.class);
        Root rU = q.from(Users.class);

        q.multiselect(rP.get("id"), rP.get("title"),
                rP.get("description"),
                rLP.get("price"), rLP.get("location"),
                rA.get("district"), rA.get("city"),
                rI.get("image"), rP.get("createdDate"),
                rU.get("firstName"), rU.get("lastName"),
                rP.get("createdDate"), rU.get("avatar"), rLP.get("quantity"));

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rU.get("id"), rL.get("id")));

        predicates.add(b.equal(rLP.get("lessorId"), rL.get("id")));
        predicates.add(b.equal(rLP.get("areaId"), rA.get("id")));
        predicates.add(b.equal(rLP.get("id"), rP.get("id")));

        //predicates.add(b.equal(rI.get("lessorId"), rL.get("id")));
        predicates.add(b.equal(rI.get("postId"), rP.get("id")));

        String fromPrice = params.get("fromPrice");
        if (fromPrice != null && !fromPrice.isEmpty()) {
            predicates.add(b.greaterThanOrEqualTo(rLP.get("price"), Double.parseDouble(fromPrice)));
        }

        String toPrice = params.get("toPrice");
        if (toPrice != null && !toPrice.isEmpty()) {
            predicates.add(b.lessThanOrEqualTo(rLP.get("price"), Double.parseDouble(toPrice)));
        }
        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(rP.get("title"), String.format("%%%s%%", kw)));
        }

        String cityCode = params.get("cityCode");
        System.out.println("CityCode: " + cityCode);
        if (cityCode != null && !cityCode.isEmpty()) {
            predicates.add(b.equal(rA.get("city"), cityCode));
        }

        String areaCode = params.get("areaId");
        System.out.println("areaId: " + areaCode);

        if (areaCode != null && !areaCode.isEmpty()) {
            predicates.add(b.equal(rLP.get("areaId"), Integer.parseInt(areaCode)));
        }

        q.where(predicates.toArray(Predicate[]::new));
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public LessorPost getLessorPostById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(LessorPost.class, id);
    }

    @Override
    public LessorPost getPostById(int id) {
//        Session session = this.factory.getObject().getCurrentSession();
//        try {
//            LessorPost lessorPost = session.createQuery("FROM LessorPost p WHERE p.id = :id", LessorPost.class).getSingleResult();
//            Hibernate.initialize(lessorPost.getPost().getImagesSet());
//            return LessorPostDTO.con;
//        } catch (NoResultException ex) {
//            ex.printStackTrace();
//            return null;
//        }
        return null;
    }

    @Override
    public void deleteLessorPost(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        LessorPost l = this.getLessorPostById(id);
        s.delete(l);
    }

    @Override
    public boolean createLessorPost(LessorPost lp) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(lp);
            return true;
        } catch (NoResultException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
