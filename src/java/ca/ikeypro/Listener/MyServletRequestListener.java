package ca.ikeypro.Listener;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Judith
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    private static final Logger LOG = Logger.getLogger(MyServletContextListener.class.getName()); 

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
       // LOG.log(Level.INFO,"\n=*=*=*=*=*=*= La requete {0} vient d'être crée =*=*=*=*=*=*=", sre.getClass().getName());
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        
       // LOG.log(Level.INFO,"\n=*=*=*=*=*=*= La requete {0} vient d'être detruite =*=*=*=*=*=*=", sre.getClass().getName());        
    }    
}
