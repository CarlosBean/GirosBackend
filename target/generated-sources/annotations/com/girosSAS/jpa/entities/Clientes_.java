package com.girosSAS.jpa.entities;

import com.girosSAS.jpa.entities.Ciudades;
import com.girosSAS.jpa.entities.Giros;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-15T23:32:41")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> numDocumento;
    public static volatile SingularAttribute<Clientes, Ciudades> ciudadesId;
    public static volatile ListAttribute<Clientes, Giros> girosList1;
    public static volatile SingularAttribute<Clientes, Integer> id;
    public static volatile SingularAttribute<Clientes, String> nombres;
    public static volatile ListAttribute<Clientes, Giros> girosList;

}