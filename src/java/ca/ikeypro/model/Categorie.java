/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.model;

/**
 *
 * @author Anis
 */
public class Categorie {

    private String idCategorie;
    private String categorie;

    public Categorie() {
    }

    public Categorie(String idCategorie, String categorie) {
        this.idCategorie = idCategorie;
        this.categorie = categorie;
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    
}
