/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.DAO;

/**
 *
 * @author Anis
 */
public class LignePanier {
    
    private String codeProduit;
    private String qte;
    private float prix;
    private String image;

    public LignePanier() {
    }

    public LignePanier(String codeProduit, String qte, float prix, String image) {
        this.codeProduit = codeProduit;
        this.qte = qte;
        this.prix = prix;
        this.image = image;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getQte() {
        return qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
