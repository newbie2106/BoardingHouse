package com.tth.pojo;

import com.tth.pojo.Lessor;
import com.tth.pojo.Post;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-12T23:59:57")
@StaticMetamodel(Images.class)
public class Images_ { 

    public static volatile SingularAttribute<Images, String> image;
    public static volatile SingularAttribute<Images, Integer> id;
    public static volatile SingularAttribute<Images, Post> postId;
    public static volatile SingularAttribute<Images, Lessor> lessorId;

}