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
public class AffectationCodeBarre implements Serializable {

    @OneToOne(mappedBy = "affectationCodeBarre")
    private ReformeItem reformeItem;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Produit produit;
    private String codeBarre;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCodeBarre;
    @ManyToOne
    private LigneRegistreInventaire ligneRegistreInventaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReformeItem getReformeItem() {
        if (reformeItem == null) {
            reformeItem = new ReformeItem();
        }
        return reformeItem;
    }

    public void setReformeItem(ReformeItem reformeItem) {
        this.reformeItem = reformeItem;
    }

    public Produit getProduit() {
        if(produit==null)
            produit=new Produit();
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public Date getDateCodeBarre() {
        if(dateCodeBarre==null)
            dateCodeBarre=new Date();
        return dateCodeBarre;
    }

    public void setDateCodeBarre(Date dateCodeBarre) {
        this.dateCodeBarre = dateCodeBarre;
    }

    public LigneRegistreInventaire getLigneRegistreInventaire() {
        if(ligneRegistreInventaire==null)
            ligneRegistreInventaire=new LigneRegistreInventaire();
        return ligneRegistreInventaire;
    }

    public void setLigneRegistreInventaire(LigneRegistreInventaire ligneRegistreInventaire) {
        this.ligneRegistreInventaire = ligneRegistreInventaire;
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
        if (!(object instanceof AffectationCodeBarre)) {
            return false;
        }
        AffectationCodeBarre other = (AffectationCodeBarre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AffectationCodeBarre{" + "reformeItem=" + reformeItem + ", id=" + id + ", produit=" + produit + ", codeBarre=" + codeBarre + ", dateCodeBarre=" + dateCodeBarre + ", ligneRegistreInventaire=" + ligneRegistreInventaire + '}';
    }

}
