/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girosSAS.rest.services;

import com.girosSAS.jpa.entities.Departamentos;
import com.girosSAS.jpa.sessions.DepartamentosFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ADMIN
 */
@Path("departamentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartamentosREST {
    
    @EJB
    private DepartamentosFacade departamentoEJB;
    
    @GET
    public List<Departamentos> findAll(){
        return departamentoEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Departamentos findBye(
    @PathParam("nombre")String nombre){
        return departamentoEJB.find(nombre);
    }
    @POST
    public void create(Departamentos departamento){
        departamentoEJB.create(departamento);
    }
}
