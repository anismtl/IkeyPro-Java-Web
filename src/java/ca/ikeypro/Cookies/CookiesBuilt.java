package ca.ikeypro.Cookies;

import javax.servlet.http.Cookie;

/**
 *
 * @author Judith
 */
public class CookiesBuilt extends Cookie{
    public CookiesBuilt(String name, String value, int days) {
        super(name, value);
        setMaxAge(60 * 60 * 24 * days);
        System.out.println("(=*=*=*=*=*=*=*=*=Cookie " + name + " ajoute avec un periode de "+days+" jours(=*=*=*=*=*=*=*=*=");
    }    
}
