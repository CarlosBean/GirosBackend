/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girosSAS.rest.services;

import com.girosSAS.jpa.entities.Clientes;
import com.girosSAS.jpa.sessions.ClientesFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ADMIN
 */
@Path("clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientesREST {
    @EJB
    private ClientesFacade usuarioEJB;

    @GET
    //@RolesAllowed({"ADMIN"})
    public List<Clientes> findAll() {
        return usuarioEJB.findAll();
    }
    
    @GET
    @Path("{id}")
    public Clientes findById(
            @PathParam("id") Integer id){
        return usuarioEJB.find(id);
    }
    
@POST
public Response create (Clientes usuario){
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();
    
    
    try{   
        if (usuarioEJB.findClienteByNumDocumento(usuario.getNumDocumento()) == null){
                
                usuarioEJB.create(usuario);
                    return Response.status(Response.Status.CREATED)
                            .entity(gson.toJson("El cliente se registro correctamente"))
                            .build();  
             }else {
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(gson.toJson("El numero de documento ya se encuentra registrado"))
                            .build();
                }
    }catch (Exception e) {
            System.out.println("Err" + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar el cliente"))
                    .build();
        }
}
}
