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
public class LigneRegistreInventaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long numOrdre;
    @ManyToOne
    private FeuilleRegistreMutation feuilleRegistreMutation;
    @ManyToOne
    private Provenance provenance;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInscription;

    private double qte;
    @ManyToOne
    private Produit produit;

    private double prix;
    @ManyToOne
    private Etat etatObjet;
    private String observation;
    @OneToMany
    private List<AffectationCodeBarre> pieces;
    @ManyToOne
    private Utilisateur individu;

    @ManyToOne
    private RegistreInventaire registreInventaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(Long numOrdre) {
        this.numOrdre = numOrdre;
    }

    public FeuilleRegistreMutation getFeuilleRegistreMutation() {
        if (feuilleRegistreMutation == null) {
            feuilleRegistreMutation = new FeuilleRegistreMutation();
        }
        return feuilleRegistreMutation;
    }

    public void setFeuilleRegistreMutation(FeuilleRegistreMutation feuilleRegistreMutation) {
        this.feuilleRegistreMutation = feuilleRegistreMutation;
    }

    public Provenance getProvenance() {
        if (provenance == null) {
            provenance = new Provenance();
        }
        return provenance;
    }

    public void setProvenance(Provenance provenance) {
        this.provenance = provenance;
    }

    public Date getDateInscription() {
        if (dateInscription == null) {
            dateInscription = new Date();
        }

        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    public Produit getProduit() {
        if (produit == null) {
            produit = new Produit();
        }
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Etat getEtatObjet() {
        if (etatObjet == null) {
            etatObjet = new Etat();
        }
        return etatObjet;
    }

    public void setEtatObjet(Etat etatObjet) {
        this.etatObjet = etatObjet;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public List<AffectationCodeBarre> getPieces() {
        if (pieces == null) {
            pieces = new ArrayList();
        }
        return pieces;
    }

    public void setPieces(List<AffectationCodeBarre> pieces) {
        this.pieces = pieces;
    }

    public Utilisateur getIndividu() {
        if (individu == null) {
            individu = new Utilisateur();
        }
        return individu;
    }

    public void setIndividu(Utilisateur individu) {
        this.individu = individu;
    }

    public RegistreInventaire getRegistreInventaire() {
        if (registreInventaire == null) {
            registreInventaire = new RegistreInventaire();
        }
        return registreInventaire;
    }

    public void setRegistreInventaire(RegistreInventaire registreInventaire) {
        this.registreInventaire = registreInventaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numOrdre != null ? numOrdre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the numOrdre fields are not set
        if (!(object instanceof LigneRegistreInventaire)) {
            return false;
        }
        LigneRegistreInventaire other = (LigneRegistreInventaire) object;
        if ((this.numOrdre == null && other.numOrdre != null) || (this.numOrdre != null && !this.numOrdre.equals(other.numOrdre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LigneRegistreInventaire{" + "id=" + id + ", numOrdre=" + numOrdre + ", dateInscription=" + dateInscription + ", qte=" + qte + ", produit=" + produit + ", prix=" + prix + ", observation=" + observation + '}';
    }

}
