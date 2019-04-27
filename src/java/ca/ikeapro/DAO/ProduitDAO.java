package ca.ikeapro.DAO;

import ca.ikeypro.Utilitaire.DataManager;
import ca.ikeypro.model.Produit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Judith
 */
public class ProduitDAO {
        public static ArrayList getListeProduit(String idCategorie) {
        ArrayList liste = new ArrayList();
        Connection conn;
        try {
            conn = DataManager.getInstance().getConnection();
            System.out.println("Produits Connected");
            String strQuery = "SELECT * FROM PRODUIT WHERE ID_CATEGORIE =\'"+idCategorie+"\'";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(strQuery);
            System.out.println(strQuery);
            Produit prod;
            while (rs.next()) {
                    prod=new Produit();
                    prod.setCodeProduit(rs.getString("CODE_PRODUIT"));
                    prod.setProduit(rs.getString("PRODUIT"));
                  //prod.setDateRelease(rs.getString("DATE_RELEASE"));
                    prod.setPrix(rs.getDouble("PRIX"));
                  //prod.setPlateforme(rs.getString("PLATEFORME"));
                    prod.setEditeur(rs.getString("ID_EDITEUR"));
                  //prod.setEdition(rs.getString("ID_EDITION"));
                  //prod.setLangue(rs.getString("LANGUE"));
                    prod.setImage(rs.getString("IMAGE"));
                  //prod.setDisponibilite(rs.getShort("DISPONIBILITE"));
                    liste.add(prod);
            }
            return liste;
        }catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("not Connected");
        } finally {
            DataManager.getInstance().closeConnection();
        }
        return liste;
    }       
}