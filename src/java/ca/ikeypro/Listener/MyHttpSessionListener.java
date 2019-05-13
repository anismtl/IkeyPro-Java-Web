package ca.ikeypro.Listener;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Judith
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    private static final Logger LOG = Logger.getLogger(MyServletContextListener.class.getName());
    private int sessionCount = 0;
    HttpSession session = null;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        synchronized (this) {
            sessionCount++;
            System.out.println("Now  sessionsCreated active sessions");
            session = se.getSession();
            System.out.println("Session Attribute ctx : " + session);

        }
        LOG.log(Level.INFO, "\n=*=*=*=*=*=*= La session vient de demarré - {0} sessions en memoire =*=*=*=*=*=*=", sessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        synchronized (this) {
            System.out.println("Now  sessionsDestroyed  no active sessions");

            sessionCount--;
        }
        LOG.log(Level.INFO, "\n=*=*=*=*=*=*= La session vient d'être detruite- {0} sessions en memoire =*=*=*=*=*=*=", sessionCount);
    }
}
