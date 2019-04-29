package ca.ikeypro.DAO;

import ca.ikeypro.Utilitaire.DataManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Judith
 */
public class ClientDAO {
    public static Client find (String user, String password) {
        Client client = null;
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "SELECT * FROM CLIENT WHERE COURRIEL ='" + user + "' AND MOT_PASSE ='" + password + "'";
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(req);
                if (rs.next()) {
                    client = new Client();
                    client.setIdClient("ID_CLIENT");
                    client.setNomClient("NOM_CLIENT");
                    client.setPrenomClient("PRENOM_CLIENT");
                    client.setCourriel("COURRIEL");
                    client.setTel("TEL");
                    client.setAdresseClient("ADRESSE_CLIENT");
                    client.setMotPasse("MOT_PASSE");
                    return client;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return client;
    }   
}
