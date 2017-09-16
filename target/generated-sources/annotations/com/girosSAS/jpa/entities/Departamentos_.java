package com.girosSAS.jpa.entities;

import com.girosSAS.jpa.entities.Ciudades;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-15T23:32:41")
@StaticMetamodel(Departamentos.class)
public class Departamentos_ { 

    public static volatile SingularAttribute<Departamentos, String> departamento;
    public static volatile SingularAttribute<Departamentos, Integer> id;
    public static volatile ListAttribute<Departamentos, Ciudades> ciudadesList;

}