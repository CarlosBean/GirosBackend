package com.girosSAS.jpa.entities;

import com.girosSAS.jpa.entities.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-15T23:32:41")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> numDocumento;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile ListAttribute<Usuarios, Roles> rolesList;
    public static volatile SingularAttribute<Usuarios, Integer> idUsuarios;
    public static volatile SingularAttribute<Usuarios, String> email;
    public static volatile SingularAttribute<Usuarios, String> nombres;

}