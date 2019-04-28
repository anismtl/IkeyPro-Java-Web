package ca.ikeypro.Listener;

import ca.ikeypro.DAO.Categorie;
import ca.ikeypro.DAO.CategorieDAO;
import ca.ikeypro.DAO.Produit;
import ca.ikeypro.DAO.ProduitDAO;
import ca.ikeypro.Utilitaire.DataManager;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
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
          List<Categorie> ListeCategories = CategorieDAO.getListeCategorie();
          sce.getServletContext().setAttribute("ListCat", ListeCategories);
//           List<Produit> ListeMostViewProduits = ProduitDAO.getListeMostViewProduits();
//            sce.getServletContext().setAttribute("ListeMostViewProduits", ListeMostViewProduits);
                 
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.log(Level.INFO,"\n=*=*=*=*=*=*= Le contexte vient d'arreté {0} =*=*=*=*=*=*=", new Date());
        dataManager.closeConnection();
    }    
}
