package ca.ikeypro.Utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Anis
 */
public class DataManager {

    private static DataManager instance;
    private Connection connection;
    private String dbURL = "jdbc:oracle:thin:@ikeypro.ca:1521:xe";
    private String dbUserName = "ikeypro";
    private String dbPassword = "ikeypro2019";

    private DataManager() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Database Connection close Failed : " + e.getMessage());
            }
        }
    }

    public static DataManager getInstance() {
        try {
            if (instance == null) {
                instance = new DataManager();
            } else if (instance.getConnection().isClosed()) {
                instance = new DataManager();
            }
            return instance;
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
}
