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
public class ExpressionBesoin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateExpressionBesoin;
    private int recu; //0:rien && 1:partiel 2:la totalité reçue 
    @ManyToOne
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "expressionBesoin")
    private List<LigneExpressionBesoin> ligneExpressionBesoins;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateExpressionBesoin() {
        if(dateExpressionBesoin==null)
            dateExpressionBesoin=new Date();
        return dateExpressionBesoin;
    }

    public void setDateExpressionBesoin(Date dateExpressionBesoin) {
        this.dateExpressionBesoin = dateExpressionBesoin;
    }

    public int getRecu() {
        return recu;
    }

    public void setRecu(int recu) {
        this.recu = recu;
    }

    public Utilisateur getUtilisateur() {
        if(utilisateur==null)
            utilisateur=new Utilisateur();
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<LigneExpressionBesoin> getLigneExpressionBesoins() {
        if(ligneExpressionBesoins==null)
            ligneExpressionBesoins=new ArrayList();
        return ligneExpressionBesoins;
    }

    public void setLigneExpressionBesoins(List<LigneExpressionBesoin> ligneExpressionBesoins) {
        this.ligneExpressionBesoins = ligneExpressionBesoins;
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
        if (!(object instanceof ExpressionBesoin)) {
            return false;
        }
        ExpressionBesoin other = (ExpressionBesoin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExpressionBesoin{" + "id=" + id + ", dateExpressionBesoin=" + dateExpressionBesoin + ", recu=" + recu + '}';
    }

}
