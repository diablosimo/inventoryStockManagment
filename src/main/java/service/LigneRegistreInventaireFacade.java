/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.AffectationCodeBarre;
import bean.Categorie;
import bean.Etat;
import bean.LigneRegistreInventaire;
import bean.Paragraphe;
import bean.Produit;
import bean.Provenance;
import bean.RegistreInventaire;
import bean.Utilisateur;
import controller.util.SearchUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author simob
 */
@Stateless
public class LigneRegistreInventaireFacade extends AbstractFacade<LigneRegistreInventaire> {

    @PersistenceContext(unitName = "inventoryStockManagment_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LigneRegistreInventaireFacade() {
        super(LigneRegistreInventaire.class);
    }

    public List<LigneRegistreInventaire> findByCriteria(RegistreInventaire registeInventaire, Long numOrdre, Long numFeuille,
            Provenance provenance, Date dateInscriptionMin, Date dateInscriptionMax,
            double qteMin, double qteMax, double prixMin, double prixMax,
            Etat etat, String codeBarre,
            Categorie categorie, Paragraphe paragraphe, Produit produit,
            Utilisateur individu) {
        List<LigneRegistreInventaire> res=new ArrayList<>();
        String req = "SELECT lri FROM LigneRegistreInventaire lri WHERE 1=1";
        System.out.println("0=>"+req);
        if (registeInventaire != null) {
            req += SearchUtil.addConstraint("lri", "registreInventaire.id", "=", registeInventaire.getId());
                    System.out.println("1=>"+req);
        }
        req += SearchUtil.addConstraint("lri", "numOrdre", "=", numOrdre);
                System.out.println("2=>"+req);
        req += SearchUtil.addConstraint("lri", "feuilleRegistreMutation.numFeuille", "=", numFeuille);
        System.out.println("3=>"+req);
        if (provenance != null) {
            req += SearchUtil.addConstraint("lri", "provenance.id", "=", provenance.getId());
            System.out.println("4=>"+req);
        }
        req += SearchUtil.addConstraintMinMaxDate("lri", "dateInscription", dateInscriptionMin, dateInscriptionMax);
        System.out.println("5=>"+req);
        req += SearchUtil.addConstraintMinMax("lri", "qte", qteMin, qteMax);
        System.out.println("6=>"+req);
        req += SearchUtil.addConstraintMinMax("lri", "prix", prixMin, prixMax);
        System.out.println("7=>"+req);
        if (etat != null) {
            req += SearchUtil.addConstraint("lri", "etatObjet.id", "=", etat.getId());
            System.out.println("8=>"+req);
        }
        if (codeBarre != null) {
            List<Object> ids = findIdByCodeBarre(codeBarre);
            req += SearchUtil.addConstraintIn("lri", "id", ids);
            System.out.println("9=>"+req);
        }
        if (produit == null || produit.getId() == null) {
            if (paragraphe == null || paragraphe.getId() == null) {
                if (categorie != null) {
                    req += SearchUtil.addConstraint("lri", "produit.paragraphe.categorie.id", "=", categorie.getId());
                    System.out.println("10=>"+req);
                }
            } else {
                req += SearchUtil.addConstraint("lri", "produit.paragraphe.id", "=", paragraphe.getId());
                System.out.println("11=>"+req);
            }
        } else {
            req += SearchUtil.addConstraint("lri", "produit.id", "=", produit.getId());
            System.out.println("12=>"+req);

        }
        req += SearchUtil.addConstraint("lri", "individu.id", "=", individu.getId());
        System.out.println("13=>"+req);
        res=em.createQuery(req).getResultList();
        System.out.println("14res=>"+res);
        return res;
    }

    public List<Object> findIdByCodeBarre(String codeBarre) {
        return em.createQuery("SELECT acb.id FROM AffectationCodeBarre acb WHERE acb.codeBarre='" + codeBarre + "'").getResultList();
    }
}
