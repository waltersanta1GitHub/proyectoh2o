package com.quimiespel.quimiespelmaven.beans;

import com.quimiespel.quimiespelmaven.map.Unidades;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jose.santamaria
 */
@Stateless
public class UnidadesFacade extends AbstractFacade<Unidades> {

    @PersistenceContext(unitName = "com.quimiespel_QuimiespelMaven_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadesFacade() {
        super(Unidades.class);
    }
    
}
