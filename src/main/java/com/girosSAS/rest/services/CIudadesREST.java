/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girosSAS.rest.services;

import com.girosSAS.jpa.entities.Ciudades;
import com.girosSAS.jpa.sessions.CiudadesFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ADMIN
 */
@Path ("ciudades")
@Consumes (MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CIudadesREST {
    @EJB
    private CiudadesFacade ciudadEJB;
    
    @GET
    public List<Ciudades> findAll(){
        return ciudadEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Ciudades findBye(
    @PathParam("ciudad")String nombre){
        return ciudadEJB.find(nombre);
    }
    
    @GET
    @Path("find")
    public List<Ciudades> findByNombre(
        @QueryParam("ciudad") String nombreCiudad,
        @QueryParam("DepartamentosId") Integer idDepartamento){
        return ciudadEJB.findCiudadByNombre(nombreCiudad, idDepartamento);
    }
    
    @POST
    public void create(Ciudades ciudad){
        ciudadEJB.create(ciudad);
    }
}
