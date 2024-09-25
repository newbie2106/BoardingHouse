package com.tth.pojo;

import com.tth.pojo.Follow;
import com.tth.pojo.Images;
import com.tth.pojo.LessorPost;
import com.tth.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-12T23:59:57")
@StaticMetamodel(Lessor.class)
public class Lessor_ { 

    public static volatile SetAttribute<Lessor, LessorPost> lessorPostSet;
    public static volatile SetAttribute<Lessor, Follow> followSet;
    public static volatile SingularAttribute<Lessor, Integer> id;
    public static volatile SetAttribute<Lessor, Images> imagesSet;
    public static volatile SingularAttribute<Lessor, Users> users;
    public static volatile SingularAttribute<Lessor, String> cccd;

}