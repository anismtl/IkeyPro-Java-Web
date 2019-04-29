/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.DAO;

import ca.ikeypro.Utilitaire.DataManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

/**
 *
 * @author Anis
 */
public class NewsletterDAO {

    public static String Inscription(String Courriel) {

        Connection conn = DataManager.getInstance().getConnection();
        String message = null;
        if (conn != null) {
            try {
                // String req = "UPDATE PRODUIT SET NBCONSULT=" + nbConsult + " WHERE CODE_PRODUIT=\'" + idProdit + "\'";
                String req = "INSERT INTO NEWSLETTER"
                        + " (ID,COURRIEL,ETAT) VALUES (NEWSLETTER_ID_SQ.NEXTVAL,'" + Courriel + "','ACTIVE')";
                System.out.println(req);
                Statement statement = conn.createStatement();
                statement.executeUpdate(req);
                 message="courriel inscrit a la newsletter";
            } catch (SQLException ex) {
                // ex.printStackTrace();
                if (ex instanceof SQLIntegrityConstraintViolationException) {
                   message="cet courriel est deja inscrit";
                   // System.out.println("Existe deja");
                } else {
                   message="erreur inconnu"; // Other SQL Exception
                }
            } finally {
                DataManager.getInstance().closeConnection();
               // message="Merci inscription reussi"; 
            }
        }
        return message;
    }

}
