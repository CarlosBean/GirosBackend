/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girosSAS.jpa.sessions;

import com.girosSAS.jpa.entities.Usuarios;
import com.girosSAS.jpa.entities.Usuarios_;
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
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "com.girosSAS_GirosSAS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios findUsuarioByEmail(String email){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
        Root<Usuarios> usuario = cq.from(Usuarios.class);
        cq.where(cb.equal(usuario.get(Usuarios_.email), email));
        TypedQuery<Usuarios> q = getEntityManager().createQuery(cq);
        try {
            return (Usuarios) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public Usuarios findUsuarioByNumDocumento(String numDocumento) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
        Root<Usuarios> usuario = cq.from(Usuarios.class);
        cq.where(cb.equal(usuario.get(Usuarios_.numDocumento), numDocumento));
        TypedQuery<Usuarios> q = getEntityManager().createQuery(cq);
        try {
            return (Usuarios) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
