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
public class FeuilleRegistreMutation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long numFeuille;
    
    @OneToMany(mappedBy = "feuilleRegistreMutation")
    private List<Facture> factures;
    @ManyToOne
    private RegistreMutation  registreMutation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumFeuille() {
        return numFeuille;
    }

    public void setNumFeuille(Long numFeuille) {
        this.numFeuille = numFeuille;
    }

    public List<Facture> getFactures() {
        if(factures==null)
            factures=new ArrayList();
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public RegistreMutation getRegistreMutation() {
        if(registreMutation==null)
            registreMutation=new RegistreMutation();
        return registreMutation;
    }

    public void setRegistreMutation(RegistreMutation registreMutation) {
        this.registreMutation = registreMutation;
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
        if (!(object instanceof FeuilleRegistreMutation)) {
            return false;
        }
        FeuilleRegistreMutation other = (FeuilleRegistreMutation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FeuilleRegistreMutation{" + "id=" + id + ", numFeuille=" + numFeuille + '}';
    }

}
