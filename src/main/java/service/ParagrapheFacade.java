/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Categorie;
import bean.Paragraphe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author simob
 */
@Stateless
public class ParagrapheFacade extends AbstractFacade<Paragraphe> {

    @PersistenceContext(unitName = "inventoryStockManagment_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParagrapheFacade() {
        super(Paragraphe.class);
    }

    public List<Paragraphe> findByCategorie(Categorie categorie) {
        System.out.println("param de findByCategorie=>" + categorie);
        if (categorie == null) {
            return null;
        } else if (categorie.getId() == null) {
            return null;
        } else {
            List<Paragraphe> res = (List<Paragraphe>) em.createQuery("SELECT p FROM Paragraphe p WHERE p.categorie.id='" + categorie.getId() + "'").getResultList();
            System.out.println("res findByCategorie=>" + res);
            return res;
        }
    }

}
