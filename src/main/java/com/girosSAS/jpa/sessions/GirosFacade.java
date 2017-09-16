/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girosSAS.jpa.sessions;

import com.girosSAS.jpa.entities.Giros;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ADMIN
 */
@Stateless
public class GirosFacade extends AbstractFacade<Giros> {

    @PersistenceContext(unitName = "com.girosSAS_GirosSAS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirosFacade() {
        super(Giros.class);
    }
    
}
