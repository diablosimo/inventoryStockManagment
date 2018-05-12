/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author simob
 */
@Entity
public class Produit implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String description;
    private double prixUnit;
    @ManyToOne
    private TypeProduit typeProduit;
    @ManyToOne
    private Etat etatObjet;
    @OneToMany(mappedBy = "produit")
    private List<AffectationCodeBarre> pieces;
    @OneToMany(mappedBy = "produit")
    private List<LigneCommande> ligneCommandes;
    @OneToMany(mappedBy = "produit")
    private List<Stock> stocks;

    @ManyToOne
    private Paragraphe paragraphe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<LigneCommande> getLigneCommandes() {
        if (ligneCommandes == null) {
            ligneCommandes = new ArrayList();
        }
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public List<Stock> getStocks() {
        if (stocks == null) {
            stocks = new ArrayList();
        }
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrixUnit() {
        return prixUnit;
    }

    public void setPrixUnit(double prixUnit) {
        this.prixUnit = prixUnit;
    }

    public TypeProduit getTypeProduit() {
        if (typeProduit == null) {
            typeProduit = new TypeProduit();
        }
        return typeProduit;
    }

    public void setTypeProduit(TypeProduit typeProduit) {
        this.typeProduit = typeProduit;
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

    public Paragraphe getParagraphe() {
        if (paragraphe == null) {
            paragraphe = new Paragraphe();
        }
        return paragraphe;
    }

    public void setParagraphe(Paragraphe paragraphe) {
        this.paragraphe = paragraphe;
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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", libelle=" + libelle + ", description=" + description + ", prixUnit=" + prixUnit + '}';
    }

}
