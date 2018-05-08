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
        return "bean.Radiation[ id=" + id + " ]";
    }
    
}
