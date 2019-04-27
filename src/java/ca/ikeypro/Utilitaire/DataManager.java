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
            LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Database Connection Creation succes =*=*=*=*=*=*=");
        } catch (ClassNotFoundException ex) {
            LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Database Connection Creation Failed =*=*=*=*=*=*=", ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Database Close succes =*=*=*=*=*=*=");
            } catch (SQLException ex) {
               LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Database Close Failed =*=*=*=*=*=*=", ex.getMessage());
            }
        }
    }

    public static DataManager getInstance() {
        try {
            if (instance == null) {
                instance = new DataManager();
                LOG.log(Level.INFO, "\n=*=*=*=*=*=*= New instance Database =*=*=*=*=*=*=");                
            } else if (instance.getConnection().isClosed()) {
                instance = new DataManager();
                LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Instance Database existed =*=*=*=*=*=*=");                
            }
            return instance;
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
}
