package ca.ikeypro.Listener;

import ca.ikeypro.Utilitaire.DataManager;
import java.sql.Connection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Judith
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(MyServletContextListener.class.getName()); 
    private static DataManager dataManager;
    public static Connection connection;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.log(Level.INFO,"\n=*=*=*=*=*=*= Le contexte vient de demarré {0} =*=*=*=*=*=*=", new Date());
        dataManager = DataManager.getInstance();
        connection = dataManager.getConnection();
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.log(Level.INFO,"\n=*=*=*=*=*=*= Le contexte vient d'arreté {0} =*=*=*=*=*=*=", new Date());
        dataManager.closeConnection();
    }    
}
