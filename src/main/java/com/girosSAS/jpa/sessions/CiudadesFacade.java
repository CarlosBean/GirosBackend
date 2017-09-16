/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girosSAS.jpa.sessions;

import com.girosSAS.jpa.entities.Ciudades;
import com.girosSAS.jpa.entities.Ciudades_;
import com.girosSAS.jpa.entities.Departamentos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author ADMIN
 */
@Stateless
public class CiudadesFacade extends AbstractFacade<Ciudades> {

    @PersistenceContext(unitName = "com.girosSAS_GirosSAS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadesFacade() {
        super(Ciudades.class);
    }
    
    public List<Ciudades> findCiudadByNombre(String query, Integer idDepartamento) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Ciudades> cq = cb.createQuery(Ciudades.class);
        Root<Ciudades> ciudad = cq.from(Ciudades.class);
        
        Predicate restrictions = cb.conjunction();
        
        if (idDepartamento != null) {
            restrictions = cb.and(restrictions, cb.equal(ciudad.get(Ciudades_.departamentosId), new Departamentos(idDepartamento)));
        }
        
        if (query != null) {
            restrictions = cb.and(restrictions,cb.like(ciudad.get(Ciudades_.ciudad), "%" + query + "%"));
        }
        
        cq.where(restrictions);
        cq.orderBy(cb.asc(ciudad.get(Ciudades_.ciudad)));
        TypedQuery<Ciudades> q = em.createQuery(cq);
        try {
            return q.setMaxResults(10).getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
