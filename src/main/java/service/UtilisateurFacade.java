/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.TypeUtilisateur;
import bean.Utilisateur;
import controller.util.HashageUtil;
import controller.util.SessionUtil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author simob
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> {

    @PersistenceContext(unitName = "inventoryStockManagment_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    public Utilisateur findByMatricule(String matricule) {
        try {
            Utilisateur loadedUser = (Utilisateur) em.createQuery("select u from Utilisateur u where u.matricule='" + matricule + "'").getSingleResult();
            if (loadedUser != null) {
                return loadedUser;
            }
        } catch (Exception e) {
            System.out.println("utilisateur introuvable");
        }
        return null;
    }

    public int seConnecter(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return -1;
        } else if (utilisateur.getMatricule() == null) {
            return -2;
        } else {
            Utilisateur loadedUser = findByMatricule(utilisateur.getMatricule());
            System.out.println("loadedUser=>" + loadedUser);
            if (loadedUser == null) {
                return -3;
            } else if (!loadedUser.getPassword().equals(HashageUtil.sha256(utilisateur.getPassword()))) {
                System.out.println("pswd saisi=>"+utilisateur.getPassword());
                System.out.println("pswd saisi hash=>"+HashageUtil.sha256(utilisateur.getPassword()));
                System.out.println("pswd bd        =>"+loadedUser.getPassword());
                int nbrCnx = loadedUser.getNbrCnx();
                if (nbrCnx < 3) {
                    System.out.println("old nbrCnx=>" + nbrCnx);
                    loadedUser.setNbrCnx(nbrCnx + 1);
                }
                if (nbrCnx == 3) {
                    System.out.println("blocking in 3=" + nbrCnx);
                    loadedUser.setBlocked(Boolean.TRUE);
                }
                edit(loadedUser);
                return -4;
            } else if (loadedUser.getBlocked() == Boolean.TRUE) {
                return -5;
            } else {
                loadedUser.setNbrCnx(0);
                edit(loadedUser);
                loadedUser = clone(loadedUser);
                loadedUser.setPassword(null);
                SessionUtil.registerUser(loadedUser);
                int res = redirectUser(loadedUser);
                System.out.println("retour du connexion=>" + res);
                return res;
            }
        }
    }
    
    public void seDeconnecter(){
        System.out.println("connectedUser=> " + SessionUtil.getConnectedUser());
        if (SessionUtil.getConnectedUser() != null) {
            SessionUtil.deconnectUser();
        }
        System.out.println("connectedUser apres deconnexion =>" + SessionUtil.getConnectedUser());
    }

    private int redirectUser(Utilisateur utilisateur) {
        String type = utilisateur.getTypeUtilisateur().getNom();
        
        switch (type) {
            case "inventaireAdmin":
                return 1;
            case "stockAdmin":
                return 2;
            case "normal":
                return 3;
            default:
                return 0;
        }
    }

    public void clone(Utilisateur utilisateurSource, Utilisateur utilisateurDestination) {
        utilisateurDestination.setId(utilisateurSource.getId());
        utilisateurDestination.setMatricule(utilisateurSource.getMatricule());
        utilisateurDestination.setNom(utilisateurSource.getNom());
        utilisateurDestination.setPrenom(utilisateurSource.getPrenom());
        utilisateurDestination.setEmail(utilisateurSource.getEmail());
        utilisateurDestination.setTelephone(utilisateurSource.getTelephone());
        utilisateurDestination.setPassword(utilisateurSource.getPassword());
        utilisateurDestination.setBlocked(utilisateurSource.getBlocked());
        utilisateurDestination.setNbrCnx(utilisateurSource.getNbrCnx());
        utilisateurDestination.setMdpChanged(utilisateurSource.getMdpChanged());
        utilisateurDestination.setTypeUtilisateur(utilisateurSource.getTypeUtilisateur());
        utilisateurDestination.setGrade(utilisateurSource.getGrade());
        utilisateurDestination.setBureau(utilisateurSource.getBureau());
    }

    public Utilisateur clone(Utilisateur utilisateur) {
        Utilisateur cloned = new Utilisateur();
        clone(utilisateur, cloned);
        return cloned;
    }
}
