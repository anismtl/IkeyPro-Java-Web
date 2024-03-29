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
public class CategorieDAO {

    public static ArrayList getListeCategorie() {
        ArrayList listeCategorie = new ArrayList();
        Connection conn;
        try {
            conn = DataManager.getInstance().getConnection();
            String strQuery = "SELECT * FROM CATEGORIE ";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(strQuery);
            Categorie cat;
            while (rs.next()) {
                cat = new Categorie();
                cat.setIdCategorie(rs.getString("ID_CATEGORIE"));
                cat.setCategorie(rs.getString("CATEGORIE"));
                listeCategorie.add(cat);
            }
            return listeCategorie;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("not Connected");
        } finally {
            DataManager.getInstance().closeConnection();
        }
        return listeCategorie;
    }
    
    public static String getCategorie(String id) {
        String categorie="";
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "SELECT CATEGORIE FROM CATEGORIE WHERE ID_CATEGORIE ='" + id + "'";
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(req);
                if (rs.next()) {
                    categorie = rs.getString("CATEGORIE");
                }
                return categorie;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return categorie;
    }
}
