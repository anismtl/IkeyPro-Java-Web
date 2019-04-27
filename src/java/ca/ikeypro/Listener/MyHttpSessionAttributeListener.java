package ca.ikeypro.Listener;

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
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
    }    
}
