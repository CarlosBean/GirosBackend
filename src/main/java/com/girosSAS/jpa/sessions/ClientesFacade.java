/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girosSAS.jpa.sessions;

import com.girosSAS.jpa.entities.Clientes;
import com.girosSAS.jpa.entities.Clientes_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ADMIN
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "com.girosSAS_GirosSAS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }
    
    public Clientes findClienteByNumDocumento(String numDocumento) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Clientes> cq = cb.createQuery(Clientes.class);
        Root<Clientes> usuario = cq.from(Clientes.class);
        cq.where(cb.equal(usuario.get(Clientes_.numDocumento), numDocumento));
        TypedQuery<Clientes> q = getEntityManager().createQuery(cq);
        try {
            return (Clientes) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
