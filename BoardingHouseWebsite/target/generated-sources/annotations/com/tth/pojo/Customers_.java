package com.tth.pojo;

import com.tth.pojo.CustomerPost;
import com.tth.pojo.Follow;
import com.tth.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-12T23:59:57")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SetAttribute<Customers, Follow> followSet;
    public static volatile SetAttribute<Customers, CustomerPost> customerPostSet;
    public static volatile SingularAttribute<Customers, Integer> id;
    public static volatile SingularAttribute<Customers, Users> users;

}