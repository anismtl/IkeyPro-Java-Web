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
    public static void insert(Client client) {
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "INSERT INTO CLIENT (NOM_CLIENT, NOM_CLIENT, PRENOM_CLIENT, "+
                                                 "COURRIEL, TEL, ADRESSE_CLIENT, MOT_PASSE) "+
                                       "VALUES (\'"+client.getNomClient()+"\', \'"
                                                   +client.getPrenomClient()+"\', \'"
                                                   +client.getCourriel()+"\', \'"
                                                   +client.getTel()+"\', \'"
                                                   +client.getAdresseClient()+"\', \'"
                                                   +client.getMotPasse()+"\')";
                System.out.println(req);
                Statement statement = conn.createStatement();
                statement.executeUpdate(req);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
    }
    
    public static void update(String pw, String adresse, String telephone, int id) {
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "UPDATE CLIENT SET TEL=\'" + telephone + "\', ADRESSE_CLIENT=\'" + adresse + "\', MOT_PASSE= \'" +pw+"\' WHERE ID_CLIENT=" + id;
                System.out.println(req);
                Statement statement = conn.createStatement();
                statement.executeUpdate(req);
                System.out.println("Update du client");
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
    }
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
                    client.setIdClient(rs.getInt("ID_CLIENT"));
                    client.setNomClient(rs.getString("NOM_CLIENT"));
                    client.setPrenomClient(rs.getString("PRENOM_CLIENT"));
                    client.setCourriel(rs.getString("COURRIEL"));
                    client.setTel(rs.getString("TEL"));
                    client.setAdresseClient(rs.getString("ADRESSE_CLIENT"));
                    client.setMotPasse(rs.getString("MOT_PASSE"));
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
