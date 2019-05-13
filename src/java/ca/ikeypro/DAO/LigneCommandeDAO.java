package ca.ikeypro.DAO;

import ca.ikeypro.Utilitaire.DataManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Judith
 */
public class LigneCommandeDAO {

    public static void insert(int idLigne, String codeProduit, int idCommande, int qte) {

        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "INSERT INTO LIGNE_COMMANDE (ID_LIGNE_COM,CODE_PRODUIT,ID_COMMANDE,QUANTITE) VALUES ('" + idLigne + "','" + codeProduit + "','" + idCommande + "','" + qte + "')";
                System.out.println(req);
                Statement statement = conn.createStatement();
                statement.executeUpdate(req);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
    }

}
