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
        
        
        
        public static int getCommandeId(int idClient, Date dateCommande) {
       

        int IDcom = 0;
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {

                String req = "SELECT MAX(ID_COMMANDE)"
                        + " FROM COMMANDE "
                        + "WHERE ID_CLIENT ='" + idClient + "'";
                       
                System.out.println(req);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(req);
                if (rs.next()) {
                    
                   IDcom= rs.getInt(1);
                    System.out.println("DAO ID:"+IDcom);

 
                }
               
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        
        return IDcom;
    }
        
        
    
}
