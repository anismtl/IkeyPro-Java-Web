package ca.ikeypro.Listener;

import ca.ikeyPro.Cookies.CookiesUtilitaire;
import ca.ikeypro.DAO.Produit;
import ca.ikeypro.DAO.ProduitDAO;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author Judith
 */
@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    private static final Logger LOG = Logger.getLogger(MyServletContextListener.class.getName());

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String attributeName = event.getName();
        Object attributeValue = event.getValue();
        System.out.println("[Session Attribute] Added : " + attributeName + " : " + attributeValue);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String attributeName = event.getName();
        Object attributeValue = event.getValue();
        System.out.println("Session Attribute Removed : " + attributeName + " : " + attributeValue);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
    }
}
