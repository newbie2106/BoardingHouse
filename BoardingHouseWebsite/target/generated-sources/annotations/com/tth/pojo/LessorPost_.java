package com.tth.pojo;

import com.tth.pojo.Area;
import com.tth.pojo.Lessor;
import com.tth.pojo.Post;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-12T23:59:57")
@StaticMetamodel(LessorPost.class)
public class LessorPost_ { 

    public static volatile SingularAttribute<LessorPost, Integer> quantity;
    public static volatile SingularAttribute<LessorPost, Area> areaId;
    public static volatile SingularAttribute<LessorPost, Post> post;
    public static volatile SingularAttribute<LessorPost, Float> price;
    public static volatile SingularAttribute<LessorPost, BigDecimal> latitude;
    public static volatile SingularAttribute<LessorPost, String> location;
    public static volatile SingularAttribute<LessorPost, Integer> id;
    public static volatile SingularAttribute<LessorPost, Lessor> lessorId;
    public static volatile SingularAttribute<LessorPost, BigDecimal> longitude;

}