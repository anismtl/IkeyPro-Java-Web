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
    
        public static void insert(int idClient, Date dateCommande) {
      
       
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "INSERT INTO COMMANDE (ID_COMMANDE,ID_CLIENT,DATE_COMMANDE) VALUES (COMMANDE_ID_SQ.NEXTVAL,'" + idClient + "','" + dateCommande + "')";
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
        
        
        
        public static Commande getCommande(int idClient, Date dateCommande) {
       
        Commande commande = new Commande();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "SELECT MAX(ID_COMMANDE),ID_CLIENT,DATE_COMMANDE"
                        + " FROM COMMANDE "
                        + "WHERE ID_CLIENT ='" + idClient + "'"
                        + " group by id_client,date_commande";
                System.out.println(req);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(req);
                if (rs.next()) {
                    
                   
                    commande.setId_Commande(rs.getInt("MAX(ID_COMMANDE)"));
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
