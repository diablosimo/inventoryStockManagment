/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
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
    @OneToMany(mappedBy = "ligneInventaire")
    private List<AffectationCodeBarre> pieces;
    @ManyToOne
    private Utilisateur individu;
    

    @ManyToOne
    private RegistreInventaire registreInventaire;

    public Long getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(Long numOrdre) {
        this.numOrdre = numOrdre;
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
        return "bean.LigneInventaire[ id=" + numOrdre + " ]";
    }

}
