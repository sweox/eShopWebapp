package net.golovach.eshop.controller.demo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by BELSHINA on 12.02.2017.
 */
public class CookieDemoController extends HttpServlet {
    private static final String COOKIE_NAME = "counter";

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Cookie fromClient = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("Name - " + cookie.getName());
                System.out.println("Comment - " + cookie.getComment());
                System.out.println("Domain - " + cookie.getDomain());
                System.out.println("MaxAge - " + cookie.getMaxAge());
                System.out.println("Path - " + cookie.getPath());
                System.out.println("Secure - " + cookie.getSecure());
                System.out.println("Value - " + cookie.getValue());
                System.out.println("Version - " + cookie.getVersion());
                System.out.println("===================");
                if (COOKIE_NAME.equals(cookie.getName())) {
                    fromClient = cookie;
                    break;
                }
            }
        }
        if (fromClient == null) {
            response.addCookie(new Cookie(COOKIE_NAME, "" + 1));
            response.getWriter().write("You visit this page: 1 time");
        } else {
            int visitCount = Integer.valueOf(fromClient.getValue());
            response.addCookie(new Cookie(COOKIE_NAME, "" + (++visitCount /*+ 1*/)));
            response.getWriter().write("You visit this page: " + visitCount + " times");
        }
    }
}
