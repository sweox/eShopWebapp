package net.golovach.eshop.listener; /**
 * Created by BELSHINA on 07.02.2017.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.*;

public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

    // Public constructor is required by servlet spec
    public MyHttpSessionActivationListener() {
        System.out.println(">> MyHttpSessionActivationListener - NEW");
    }

    public void sessionWillPassivate(HttpSessionEvent event) {
        System.out.println(">> HttpSession - will passivate, id = " + event.getSession().getId());
    }

    public void sessionDidActivate(HttpSessionEvent event) {
        System.out.println(">> HttpSession - did passivate, id = " + event.getSession().getId());
    }
}
