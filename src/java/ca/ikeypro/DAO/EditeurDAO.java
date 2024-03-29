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
public class EditeurDAO {

    public static ArrayList getListeEditeur() {
        ArrayList listeEditeurs = new ArrayList();
        Connection conn;
        try {
            conn = DataManager.getInstance().getConnection();
            //System.out.println("Editeur Connected");
            String strQuery = "SELECT * FROM EDITEUR"
                    + " ORDER BY NBPRODUIT DESC"
                    + " FETCH FIRST 6 ROWS ONLY";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(strQuery);
            Editeur editeur;
            while (rs.next()) {
                editeur = new Editeur();
                editeur.setId_Editeur(rs.getString("ID_EDITEUR"));
                editeur.setEditeur(rs.getString("EDITEUR"));
                listeEditeurs.add(editeur);
            }
            return listeEditeurs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DataManager.getInstance().closeConnection();
        }
        return listeEditeurs;
    }

    public static String getEditeur(String id) {
        String editeur = "";
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "SELECT EDITEUR FROM EDITEUR WHERE ID_EDITEUR ='" + id + "'";
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(req);
                if (rs.next()) {
                    editeur = rs.getString("EDITEUR");
                }
                return editeur;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return editeur;
    }

}
