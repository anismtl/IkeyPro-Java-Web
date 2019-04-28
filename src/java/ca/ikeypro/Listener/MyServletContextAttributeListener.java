package ca.ikeypro.Listener;

import java.util.logging.Logger;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;

/**
 * @author Judith
 */
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

    private static final Logger LOG = Logger.getLogger(MyServletContextListener.class.getName());

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        //  HttpServlet context = (HttpServlet) event.getServletContext();
        //context.setAttribut ("stock", stock);
        String attributeName = event.getName();
        Object attributeValue = event.getValue();
        System.out.println("[Context Attribute] Added : " + attributeName + " : " + attributeValue);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        // HttpServlet context = (HttpServlet) event.getServletContext();
        String attributeName = event.getName();
        Object attributeValue = event.getValue();
        System.out.println("Context Attribute Removed : " + attributeName + " : " + attributeValue);
        //context.setAttribut ("stock", stock);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
        //   HttpServlet context = (HttpServlet) arg0.getServletContext();
        //context.setAttribut ("stock", stock);
    }

}
