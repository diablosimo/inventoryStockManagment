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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author simob
 */
@Entity
public class RegistreMutation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @OneToOne
    private EntiteAdministrative entiteAdministrative;
    @OneToMany(mappedBy = "registreMutation")
    private List<FeuilleRegistreMutation> feuilleRegistreMutations;

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

    public List<FeuilleRegistreMutation> getFeuilleRegistreMutations() {
        if (feuilleRegistreMutations == null) {
            feuilleRegistreMutations = new ArrayList();
        }
        return feuilleRegistreMutations;
    }

    public void setFeuilleRegistreMutations(List<FeuilleRegistreMutation> feuilleRegistreMutations) {
        this.feuilleRegistreMutations = feuilleRegistreMutations;
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
        if (!(object instanceof RegistreMutation)) {
            return false;
        }
        RegistreMutation other = (RegistreMutation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.RegistreMutation[ id=" + id + " ]";
    }

}
