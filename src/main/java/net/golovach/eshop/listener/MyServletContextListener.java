package net.golovach.eshop.listener; /**
 * Created by BELSHINA on 07.02.2017.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyServletContextListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public MyServletContextListener() {
        System.out.println(">> MyServletContextListener - NEW");
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent event) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        System.out.println(">> ServletContext - created, contextP");
    }

    public void contextDestroyed(ServletContextEvent event) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        System.out.println(">> ServletContext - destoyed, contextP");

    }

}
