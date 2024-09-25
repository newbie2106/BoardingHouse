package com.tth.pojo;

import com.tth.pojo.Comment;
import com.tth.pojo.Customers;
import com.tth.pojo.Lessor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-12T23:59:57")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> lastName;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile SingularAttribute<Users, String> role;
    public static volatile SingularAttribute<Users, Boolean> isActived;
    public static volatile SingularAttribute<Users, String> avatar;
    public static volatile SingularAttribute<Users, Lessor> lessor;
    public static volatile SingularAttribute<Users, String> firstName;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Date> createdDate;
    public static volatile SetAttribute<Users, Comment> commentSet;
    public static volatile SingularAttribute<Users, String> phone;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, Customers> customers;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> username;

}