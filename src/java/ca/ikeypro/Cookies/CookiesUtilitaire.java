package ca.ikeyPro.Cookies;

import javax.servlet.http.*;
/**
 *
 * @author Judith
 */
public class CookiesUtilitaire {

    public static Cookie[] getAllCookiesByName(HttpServletRequest request,
            String cookieName) {
        cookieName = cookieName.toLowerCase();
        Cookie[] cookies = request.getCookies();
        Cookie[] resultat = null;
        if (cookies != null) {
            int i = 0;
            for (Cookie cookie : cookies) {
                if (cookie.getName().toLowerCase().contains(cookieName)) {
                    resultat[i] = cookie;
                    i++;
                }
            }
        }
        return resultat;
    }

    /**
     * Given the request object, a name, and a default value, this method tries
     * to find the value of the cookie with the given name. If no cookie matches
     * the name, the default value is returned.
     */
    public static String getCookieValue(HttpServletRequest request,
            String cookieName,
            String defaultValue) {
        Cookie[] cookies = request.getCookies();
        cookieName = cookieName.toLowerCase();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName().toLowerCase())) {
                    return (cookie.getValue());
                }
            }
        }
        return (defaultValue);
    }

    /**
     * Given the request object and a name, this method tries to find and return
     * the cookie that has the given name. If no cookie matches the name, null
     * is returned.
     */
    public static Cookie getCookie(HttpServletRequest request,
            String cookieName) {
        Cookie[] cookies = request.getCookies();
        cookieName = cookieName.toLowerCase();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    System.out.println("cookie trouvée " + cookie.getName() + " value "+cookie.getValue());
                    return (cookie);
                }
            }
        }
        return (null);
    }

}
