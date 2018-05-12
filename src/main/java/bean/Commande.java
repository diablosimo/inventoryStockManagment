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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author simob
 */
@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private int Livre; //0: rien n'est livré && 1:une partie est livrée 2: tout est livré
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCommande;
    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;

    @OneToMany(mappedBy = "commande")
    private List<Facture> factures;

    @OneToMany(mappedBy = "commande")
    private List<Livraison> livraisons;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLivre() {
        return Livre;
    }

    public void setLivre(int Livre) {
        this.Livre = Livre;
    }

    public Date getDateCommande() {
        if (dateCommande == null) {
            dateCommande = new Date();
        }
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
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

    public List<Facture> getFactures() {
        if (factures == null) {
            factures = new ArrayList();
        }
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public List<Livraison> getLivraisons() {
        if (livraisons == null) {
            livraisons = new ArrayList();
        }
        return livraisons;
    }

    public void setLivraisons(List<Livraison> livraisons) {
        this.livraisons = livraisons;
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", Livre=" + Livre + ", dateCommande=" + dateCommande + '}';
    }

}
