package ca.ikeypro.Utilitaire;

import ca.ikeypro.DAO.Client;
import ca.ikeypro.DAO.ClientDAO;
import ca.ikeypro.Listener.MyServletContextListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author Judith
 */
//@WebFilter ("WEB-INF/panier/*")
public class FilterAuthentication implements Filter{
    private static final Logger LOG = Logger.getLogger(MyServletContextListener.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Le filter vient detre initialiser =*=*=*=*=*=*=");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Le filter vient detre executer =*=*=*=*=*=*=");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Client client = ClientDAO.find(username, password);
        if (client != null)  {
            LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Le client {0} vient d'etre authentifié =*=*=*=*=*=*=", username);
            // sends request to next resource
            chain.doFilter(request, response);
        } else {
            out.print("username or password is not correct!");
        }
    }
    @Override
    public void destroy() {
        LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Le filter vient detre detruit =*=*=*=*=*=*=");
    }    
}
