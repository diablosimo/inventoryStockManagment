/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author simob
 */
@Entity
public class InventaireItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private EntiteAdministrative entiteAdministrative;
    @ManyToOne
    private Utilisateur individu;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInspection;
    @ManyToOne
    private AffectationCodeBarre affectationCodeBarre;
    private String resultInspection;
    @ManyToOne
    private Inventaire inventaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EntiteAdministrative getEntiteAdministrative() {
        if (entiteAdministrative == null) {
            entiteAdministrative = new EntiteAdministrative();
        }
        return entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrative entiteAdministrative) {
        this.entiteAdministrative = entiteAdministrative;
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

    public Date getDateInspection() {
        if (dateInspection == null) {
            dateInspection = new Date();
        }
        return dateInspection;
    }

    public void setDateInspection(Date dateInspection) {
        this.dateInspection = dateInspection;
    }

    public AffectationCodeBarre getAffectationCodeBarre() {
        if (affectationCodeBarre == null) {
            affectationCodeBarre = new AffectationCodeBarre();
        }
        return affectationCodeBarre;
    }

    public void setAffectationCodeBarre(AffectationCodeBarre affectationCodeBarre) {
        this.affectationCodeBarre = affectationCodeBarre;
    }

    public String getResultInspection() {
        return resultInspection;
    }

    public void setResultInspection(String resultInspection) {
        this.resultInspection = resultInspection;
    }

    public Inventaire getInventaire() {
        if (inventaire == null) {
            inventaire = new Inventaire();
        }
        return inventaire;
    }

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
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
        if (!(object instanceof InventaireItem)) {
            return false;
        }
        InventaireItem other = (InventaireItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InventaireItem{" + "id=" + id + ", dateInspection=" + dateInspection + ", resultInspection=" + resultInspection + '}';
    }

}
