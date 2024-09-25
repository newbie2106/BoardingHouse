package com.tth.pojo;

import com.tth.pojo.Post;
import com.tth.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-12T23:59:57")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, Post> postId;
    public static volatile SingularAttribute<Comment, Users> userId;
    public static volatile SingularAttribute<Comment, String> content;
    public static volatile SingularAttribute<Comment, Date> createDate;

}