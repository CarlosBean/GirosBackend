package com.girosSAS.jpa.entities;

import com.girosSAS.jpa.entities.Clientes;
import com.girosSAS.jpa.entities.Departamentos;
import com.girosSAS.jpa.entities.Giros;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-15T23:32:41")
@StaticMetamodel(Ciudades.class)
public class Ciudades_ { 

    public static volatile ListAttribute<Ciudades, Clientes> clientesList;
    public static volatile SingularAttribute<Ciudades, String> ciudad;
    public static volatile ListAttribute<Ciudades, Giros> girosList1;
    public static volatile SingularAttribute<Ciudades, Integer> id;
    public static volatile SingularAttribute<Ciudades, Departamentos> departamentosId;
    public static volatile ListAttribute<Ciudades, Giros> girosList;

}