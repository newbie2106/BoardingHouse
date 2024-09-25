package com.tth.pojo;

import com.tth.pojo.LessorPost;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-12T23:59:57")
@StaticMetamodel(Area.class)
public class Area_ { 

    public static volatile SingularAttribute<Area, String> city;
    public static volatile SetAttribute<Area, LessorPost> lessorPostSet;
    public static volatile SingularAttribute<Area, String> district;
    public static volatile SingularAttribute<Area, Integer> id;

}