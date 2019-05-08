package ca.ikeypro.DAO;

import java.util.Date;

/**
 *
 * @author Judith
 */
public class Commande {
  private int id_Commande;
  private int idClient;
  private Date date_commande;

    public Commande() {
    }

    public Commande(int id_Commande, int idClient, Date date_commande) {
        this.id_Commande = id_Commande;
        this.idClient = idClient;
        this.date_commande = date_commande;
    }

    public int getId_Commande() {
        return id_Commande;
    }

    public void setId_Commande(int id_Commande) {
        this.id_Commande = id_Commande;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    
  
  
}
