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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Judith
 */
@WebFilter(urlPatterns = {"/WEB-INF/checkout.jsp"})
public class FilterAuthentication implements Filter{
    private static final Logger LOG = Logger.getLogger(MyServletContextListener.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Le filter vient detre initialiser =*=*=*=*=*=*=");
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Le filter vient detre executer =*=*=*=*=*=*=");
        PrintWriter out = res.getWriter();

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = "/WEB-INF/login.jsp";
        
        boolean loggedIn = session != null && session.getAttribute("client") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        
        if (loggedIn || loginRequest)  {
            LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Le client vient d'etre authentifié =*=*=*=*=*=*=");
            // sends request to next resource
            chain.doFilter(request, response);
        } else {
            out.print("username or password is not correct!");
            response.sendRedirect(loginURI);
        }
    }
    @Override
    public void destroy() {
        LOG.log(Level.INFO, "\n=*=*=*=*=*=*= Le filter vient detre detruit =*=*=*=*=*=*=");
    }    
}
