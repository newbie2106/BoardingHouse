package com.tth.pojo;

import com.tth.pojo.Customers;
import com.tth.pojo.Post;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-12T23:59:57")
@StaticMetamodel(CustomerPost.class)
public class CustomerPost_ { 

    public static volatile SingularAttribute<CustomerPost, String> address;
    public static volatile SingularAttribute<CustomerPost, Post> post;
    public static volatile SingularAttribute<CustomerPost, Customers> customerId;
    public static volatile SingularAttribute<CustomerPost, Integer> id;

}