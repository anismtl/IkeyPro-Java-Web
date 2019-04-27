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
            System.out.println("Categorie Connected");
            String strQuery = "SELECT * FROM CATEGORIE ";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(strQuery);
            System.out.println(strQuery);
            Categorie cat;
            while (rs.next()) {
                cat = new Categorie();
                cat.setIdCategorie(rs.getString("ID_CATEGORIE"));
                cat.setCategorie(rs.getString("CATEGORIE"));
                listeCategorie.add(cat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("not Connected");
        } finally {
            DataManager.getInstance().closeConnection();
        }
        return listeCategorie;
    }

    public static ArrayList<Categorie> getListeCetegorie() {
        ArrayList<Categorie> listeCategorie = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            ResultSet rs = null;
            Statement statement = null;
            System.out.println("Connected");
            try {
                String strQuery = "SELECT * FROM CATEGORIE ";
                statement = conn.createStatement();
                rs = statement.executeQuery(strQuery);
                Categorie cat;
                while (rs.next()) {
                    cat = new Categorie();
                    cat.setIdCategorie(rs.getString("ID_CATEGORIE"));
                    cat.setCategorie(rs.getString("CATEGORIE"));
                    listeCategorie.add(cat);
                }
            }//end of try
            catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("not Connected");
            } finally {
                try {
                    rs.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DataManager.getInstance().closeConnection();
            }//end of finally
        }//end of if
        return listeCategorie;
    }
}
