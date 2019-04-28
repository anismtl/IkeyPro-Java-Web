package ca.ikeypro.Utilitaire;

import ca.ikeypro.Listener.MyServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Anis
 */
public class DataManager {
    private static final Logger LOG = Logger.getLogger(MyServletContextListener.class.getName());
    private static DataManager instance;
    private Connection connection;
    private String dbURL = "jdbc:oracle:thin:@ikeypro.ca:1521:xe";
    private String dbUserName = "ikeypro";
    private String dbPassword = "ikeypro2019";

    private DataManager() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
            LOG.log(Level.INFO, "\n=*=*=*=*=*=*= La connection a été un succes =*=*=*=*=*=*=");
        } catch (ClassNotFoundException ex) {
            LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Database Connection Creation Failed {0} =*=*=*=*=*=*=",ex.getMessage());
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
                LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Database Connection Creation Failed {0} =*=*=*=*=*=*=",e.getMessage());
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
            System.out.println("\n=*=*=*=*=*=*=Database a ete bien instansier=*=*=*=*=*=*=");
            return instance;
        } catch (SQLException ex) {
            System.out.println("\n=*=*=*=*=*=*=Database Connection close Failed : " + ex.getMessage() + "=*=*=*=*=*=*=");
        }
        return instance;
    }
}
