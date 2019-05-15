package ca.ikeypro.DAO;

import ca.ikeypro.Utilitaire.DataManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Judith
 */
public class LicenseDAO {
    
            public static String getLicense(String id) {
        String edition="";
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "SELECT LICENSE FROM LICENSE WHERE CODE_PRODUIT='" + id + "' AND ETAT= 'DISPONIBLE'";
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(req);
                if (rs.next()) {
                    edition = rs.getString("LICENSE");
                }
                return edition;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return edition;
    }
    
}
