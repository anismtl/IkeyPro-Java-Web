package ca.ikeypro.DAO;

import ca.ikeypro.Utilitaire.DataManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Judith
 */
public class EditionDAO {

    public static ArrayList getListeEdition() {
        ArrayList listeEdition = new ArrayList();
        Connection conn;
        try {
            conn = DataManager.getInstance().getConnection();
            //System.out.println("Editeur Connected");
            String strQuery = "SELECT * FROM EDITION"
                    + " ORDER BY NBPRODUIT DESC"
                   + " FETCH FIRST 6 ROWS ONLY";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(strQuery);
            Edition edition;
            while (rs.next()) {
                edition = new Edition();
                edition.setId_Edition(rs.getString("ID_EDITION"));
                edition.setEdition(rs.getString("EDITION"));
                listeEdition.add(edition);
            }
            return listeEdition;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DataManager.getInstance().closeConnection();
        }
        return listeEdition;
    }
    
        public static String getEdition(String id) {
        String edition="";
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "SELECT EDITION FROM EDITION WHERE ID_EDITION ='" + id + "'";
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(req);
                if (rs.next()) {
                    edition = rs.getString("EDITION");
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
