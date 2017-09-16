/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girosSAS.rest.services;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author ADMIN
 */
@ApplicationPath("api")
public class AppConfig extends ResourceConfig{
    public AppConfig() {
        packages("co.edu.sena.adsi.rest.services;co.edu.sena.adsi.rest.auth");
        //register(RolesAllowedDynamicFeature.class);
    }
}
