package ca.ikeypro.model;

/**
 *
 * @author Anis
 */
public class Produit {
    
     private String codeProduit;
     private String categorie;
     private String editeur;
     private String edition;
     private String produit;
     private String plateforme;
     private String dateRelease;
     private double prix;
     private String langue;
     private String image;
     private short disponibilite;
     private int nbconsulte;

    public Produit() {
    }

    public Produit(String codeProduit, String produit, double prix, String image, int nbconsulte) {
        this.codeProduit = codeProduit;
        this.produit = produit;
        this.prix = prix;
        this.image = image;
        this.nbconsulte = nbconsulte;
    }

    public Produit(String codeProduit, String categorie, String editeur, String edition, String produit, String plateforme, String dateRelease, double prix, String langue, String image, short disponibilite, int nbconsulte) {
        this.codeProduit = codeProduit;
        this.categorie = categorie;
        this.editeur = editeur;
        this.edition = edition;
        this.produit = produit;
        this.plateforme = plateforme;
        this.dateRelease = dateRelease;
        this.prix = prix;
        this.langue = langue;
        this.image = image;
        this.disponibilite = disponibilite;
        this.nbconsulte = nbconsulte;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public String getPlateforme() {
        return plateforme;
    }

    public void setPlateforme(String plateforme) {
        this.plateforme = plateforme;
    }

    public String getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public short getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(short disponibilite) {
        this.disponibilite = disponibilite;
    }

    public int getNbconsulte() {
        return nbconsulte;
    }

    public void setNbconsulte(int nbconsulte) {
        this.nbconsulte = nbconsulte;
    }    
}
