/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author simob
 */
@Entity
public class CessionPassage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numBultinPassage;
    @OneToOne
    private Radiation radiation;
    @ManyToOne
    private EntiteAdministrative eaCessionnaire;
    @ManyToOne
    private Utilisateur utilisateurCessionnaire;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumBultinPassage() {
        return numBultinPassage;
    }

    public void setNumBultinPassage(String numBultinPassage) {
        this.numBultinPassage = numBultinPassage;
    }

    public Radiation getRadiation() {
        if(radiation==null)
            radiation=new Radiation();
        return radiation;
    }

    public void setRadiation(Radiation radiation) {
        this.radiation = radiation;
    }   

    public EntiteAdministrative getEaCessionnaire() {
        if(eaCessionnaire==null)
            eaCessionnaire=new EntiteAdministrative();
        return eaCessionnaire;
    }

    public void setEaCessionnaire(EntiteAdministrative eaCessionnaire) {
        this.eaCessionnaire = eaCessionnaire;
    }

    public Utilisateur getUtilisateurCessionnaire() {
        if(utilisateurCessionnaire==null)
            utilisateurCessionnaire=new Utilisateur();
        return utilisateurCessionnaire;
    }

    public void setUtilisateurCessionnaire(Utilisateur utilisateurCessionnaire) {
        this.utilisateurCessionnaire = utilisateurCessionnaire;
    }
    
    
    
    @Override
    public int hashCode(){
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CessionPassage)) {
            return false;
        }
        CessionPassage other = (CessionPassage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.CessionPassage[ id=" + id + " ]";
    }
    
}
