package ca.ikeypro.DAO;

/**
 *
 * @author Judith
 */
public class LigneCommande {

    private int id_Ligne;
    private int id_Commande;
    private String codeProduit;
    private int qte;

    public LigneCommande() {
    }

    public LigneCommande(int id_Ligne, int id_Commande, String codeProduit, int qte) {
        this.id_Ligne = id_Ligne;
        this.id_Commande = id_Commande;
        this.codeProduit = codeProduit;
        this.qte = qte;
    }

    public int getId_Ligne() {
        return id_Ligne;
    }

    public void setId_Ligne(int id_Ligne) {
        this.id_Ligne = id_Ligne;
    }

    public int getId_Commande() {
        return id_Commande;
    }

    public void setId_Commande(int id_Commande) {
        this.id_Commande = id_Commande;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

}
