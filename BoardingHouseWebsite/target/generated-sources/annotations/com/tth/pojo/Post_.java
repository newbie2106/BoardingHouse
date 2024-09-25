package com.tth.pojo;

import com.tth.pojo.Comment;
import com.tth.pojo.CustomerPost;
import com.tth.pojo.Images;
import com.tth.pojo.LessorPost;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-12T23:59:57")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, Date> createdDate;
    public static volatile SetAttribute<Post, Comment> commentSet;
    public static volatile SingularAttribute<Post, CustomerPost> customerPost;
    public static volatile SingularAttribute<Post, String> description;
    public static volatile SingularAttribute<Post, LessorPost> lessorPost;
    public static volatile SingularAttribute<Post, Integer> id;
    public static volatile SingularAttribute<Post, String> title;
    public static volatile SetAttribute<Post, Images> imagesSet;

}