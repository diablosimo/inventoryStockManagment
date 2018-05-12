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
import javax.persistence.Temporal;

/**
 *
 * @author simob
 */
@Entity
public class Radiation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private LigneRegistreInventaire ligneInventaire;
    @ManyToOne
    private FeuilleRegistreMutation feuilleRegistreMutation;
    @ManyToOne
    private Motif motif;
    private double nbrObjet;
    @ManyToOne
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRadiation;
    @ManyToOne
    private Etat etatObjet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LigneRegistreInventaire getLigneInventaire() {
        if (ligneInventaire == null) {
            ligneInventaire = new LigneRegistreInventaire();
        }
        return ligneInventaire;
    }

    public void setLigneInventaire(LigneRegistreInventaire ligneInventaire) {
        this.ligneInventaire = ligneInventaire;
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

    public Motif getMotif() {
        if (motif == null) {
            motif = new Motif();
        }
        return motif;
    }

    public void setMotif(Motif motif) {
        this.motif = motif;
    }

    public double getNbrObjet() {
        return nbrObjet;
    }

    public void setNbrObjet(double nbrObjet) {
        this.nbrObjet = nbrObjet;
    }

    public Date getDateRadiation() {
        if (dateRadiation == null) {
            dateRadiation = new Date();
        }
        return dateRadiation;
    }

    public void setDateRadiation(Date dateRadiation) {
        this.dateRadiation = dateRadiation;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Radiation)) {
            return false;
        }
        Radiation other = (Radiation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Radiation{" + "id=" + id + ", nbrObjet=" + nbrObjet + ", dateRadiation=" + dateRadiation + '}';
    }

}
