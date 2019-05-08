package ca.ikeypro.DAO;

import ca.ikeypro.Utilitaire.DataManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Judith
 */
public class CommandeDAO {
    
        private static void insert(String idClient, Date dateCommande) {
      
       
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "INSERT INTO COMMANDE (ID_COMMANDE,ID_CLIENT,DATE_COMMANDE) VALUES (COMMANDE_ID_SQ.NEXTVAL,'" + idClient + "','" + dateCommande + "')";
                //System.out.println(req);
                Statement statement = conn.createStatement();
                statement.executeUpdate(req);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
    }
        
        
        
        public static Commande getCommande(int idClient, Date dateCommande) {
       
        Commande commande = new Commande();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + " P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, "
                        + " EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P "
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR "
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION "
                        + "WHERE CODE_PRODUIT ='" + idClient + "'";
                //System.out.println(req);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(req);
                if (rs.next()) {
                    
                   
                    commande.setId_Commande(rs.getInt("ID_COMMANDE"));
                    commande.setIdClient(rs.getInt("ID_CLIENT"));
                    commande.setDate_commande(rs.getDate("DATE_COMMANDE"));
 
                }
               
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        
        return commande;
    }
        
        
    
}
