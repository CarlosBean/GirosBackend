/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girosSAS.rest.services;

import com.girosSAS.jpa.entities.Giros;
import com.girosSAS.jpa.sessions.GirosFacade;
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
@Path ("giros")
@Consumes (MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GirosREST {
    @EJB
    private GirosFacade eventoEJB;
    
    @GET
    public List<Giros> findAll(){
        return eventoEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Giros findBye(
    @PathParam("nombre")String nombre){
        return eventoEJB.find(nombre);
    }
    
    @POST
    public void create(Giros evento){
        eventoEJB.create(evento);
    }
}
