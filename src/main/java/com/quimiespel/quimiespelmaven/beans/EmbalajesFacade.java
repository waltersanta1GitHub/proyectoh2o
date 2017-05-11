/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quimiespel.quimiespelmaven.beans;

import com.quimiespel.quimiespelmaven.map.Embalajes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jose.santamaria
 */
@Stateless
public class EmbalajesFacade extends AbstractFacade<Embalajes> {

    @PersistenceContext(unitName = "com.quimiespel_QuimiespelMaven_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmbalajesFacade() {
        super(Embalajes.class);
    }
    
}
