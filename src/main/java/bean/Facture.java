/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author simob
 */
@Entity
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFacture;
    private String numContrat;
    private String numMarche;
    private double montantTotal;
    @ManyToOne
    private Commande commande;
    @ManyToOne
    private Fournisseur fournisseur;
    @ManyToOne
    private FeuilleRegistreMutation feuilleRegistreMutation;
    @OneToMany(mappedBy = "facture")
    private List<LigneFacture> ligneFactures;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateFacture() {
        if(dateFacture==null)
            dateFacture=new Date();
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getNumContrat() {
        return numContrat;
    }

    public void setNumContrat(String numContrat) {
        this.numContrat = numContrat;
    }

    public String getNumMarche() {
        return numMarche;
    }

    public void setNumMarche(String numMarche) {
        this.numMarche = numMarche;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Commande getCommande() {
        if(commande==null)
            commande=new Commande();
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Fournisseur getFournisseur() {
        if(fournisseur==null)
            fournisseur=new Fournisseur();
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public FeuilleRegistreMutation getFeuilleRegistreMutation() {
        if(feuilleRegistreMutation==null)
            feuilleRegistreMutation=new FeuilleRegistreMutation();
        return feuilleRegistreMutation;
    }

    public void setFeuilleRegistreMutation(FeuilleRegistreMutation feuilleRegistreMutation) {
        this.feuilleRegistreMutation = feuilleRegistreMutation;
    }

    public List<LigneFacture> getLigneFactures() {
        if(ligneFactures==null)
            ligneFactures=new ArrayList();
        return ligneFactures;
    }

    public void setLigneFactures(List<LigneFacture> ligneFactures) {
        this.ligneFactures = ligneFactures;
    }
        
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facture{" + "id=" + id + ", dateFacture=" + dateFacture + ", numContrat=" + numContrat + ", numMarche=" + numMarche + ", montantTotal=" + montantTotal + '}';
    }

   
    
}
