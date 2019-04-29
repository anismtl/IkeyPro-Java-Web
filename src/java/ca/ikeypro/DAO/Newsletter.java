/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.DAO;

import java.util.Date;

/**
 *
 * @author Anis
 */
public class Newsletter {
    
   private int id;
   private String courriel;
   private Date date_sub;
   private String etat;

    public Newsletter() {
    }

    public Newsletter(int id, String courriel, Date date_sub, String etat) {
        this.id = id;
        this.courriel = courriel;
        this.date_sub = date_sub;
        this.etat = etat;
    }

   
   
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public Date getDate_sub() {
        return date_sub;
    }

    public void setDate_sub(Date date_sub) {
        this.date_sub = date_sub;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
   
   
    
}
