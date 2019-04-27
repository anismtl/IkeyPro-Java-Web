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
public class ClientDAO {
    public static boolean find (String user, String password) {
        boolean isClient= false;
        String req;
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                req = "SELECT * FROM CLIENT WHERE COURRIEL ='" + user + "' AND MOT_PASSE ='" + password + "'";
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(req);
                if (rs.next()) {
                    Client client = new Client ();
                    client.setIdClient("ID_CLIENT");
                    client.setNomClient("NOM_CLIENT");
                    client.setPrenomClient("PRENOM_CLIENT");
                    client.setCourriel("COURRIEL");
                    client.setTel("TEL");
                    client.setAdresseClient("ADRESSE_CLIENT");
                    client.setMotPasse("MOT_PASSE");
                    isClient = true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return isClient;
    }   
}
