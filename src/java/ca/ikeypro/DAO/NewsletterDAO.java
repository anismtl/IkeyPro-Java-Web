/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.DAO;

import ca.ikeypro.Utilitaire.DataManager;
import ca.ikeypro.Utilitaire.MailManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javax.mail.MessagingException;

/**
 *
 * @author Anis
 */
public class NewsletterDAO {

    public static String Inscription(String Courriel) throws MessagingException {

        Connection conn = DataManager.getInstance().getConnection();
        String message = null;
        if (conn != null) {
            try {

                String req = "INSERT INTO NEWSLETTER"
                        + " (ID,COURRIEL,ETAT) VALUES (NEWSLETTER_ID_SQ.NEXTVAL,'" + Courriel + "','ACTIVE')";
                System.out.println(req);
                Statement statement = conn.createStatement();
                statement.executeUpdate(req);
                message = "Courriel inscrit a la newsletter.";
               
            } catch (SQLException ex) {

                if (ex instanceof SQLIntegrityConstraintViolationException) {
                    message = "Ce Courriel est deja inscrit";

                } else {
                    message = "erreur inconnu"; // Other SQL Exception
                }
            } finally {
                DataManager.getInstance().closeConnection();

            }
        }
        MailManager.SendNewsletterInscrisption(Courriel);
        return message;
    }

    public static String Desabonner(String Courriel) throws MessagingException {

        Connection conn = DataManager.getInstance().getConnection();
        String message = null;
        if (conn != null) {
            try {

                String req = "DELETE FROM NEWSLETTER WHERE COURRIEL=\'" + Courriel + "\'";
                System.out.println(req);
                Statement statement = conn.createStatement();
                int r = statement.executeUpdate(req);

                if (r == 1) {
                    message = "Courriel supprimé de la newsletter.";
                    
                } else {
                    message = "Ce Courriel n'existe pas dans nos listes";
                }
                System.out.println(r);

            } catch (SQLException ex) {
            } finally {
                DataManager.getInstance().closeConnection();

            }
        }
        MailManager.SendNewsletterSupression(Courriel);
        return message;
    }

}
