/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
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
public class Utilisateur implements Serializable {

    @OneToMany(mappedBy = "utilisateur")
    private List<ExpressionBesoin> expressionBesoins;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String matricule;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;
    private Boolean blocked;
    private int nbrCnx;
    private Boolean mdpChanged;
    @ManyToOne
    private TypeUtilisateur typeUtilisateur;
    private String grade;
    @ManyToOne
    private Bureau bureau;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public int getNbrCnx() {
        return nbrCnx;
    }

    public void setNbrCnx(int nbrCnx) {
        this.nbrCnx = nbrCnx;
    }

    public Boolean getMdpChanged() {
        return mdpChanged;
    }

    public void setMdpChanged(Boolean mdpChanged) {
        this.mdpChanged = mdpChanged;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Bureau getBureau() {
        if(bureau==null)
            bureau=new Bureau();
        return bureau;
    }

    public void setBureau(Bureau bureau) {
        this.bureau = bureau;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "expressionBesoins=" + expressionBesoins + ", id=" + id + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + ", telephone=" + telephone + ", blocked=" + blocked + ", nbrCnx=" + nbrCnx + ", mdpChanged=" + mdpChanged + ", typeUtilisateur=" + typeUtilisateur + ", grade=" + grade + ", bureau=" + bureau + '}';
    }

    
    
}
