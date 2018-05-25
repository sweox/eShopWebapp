package net.golovach.eshop.listener.demo; /**
 * Created by BELSHINA on 07.02.2017.
 */

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class DemoHttpSessionActivationListener implements HttpSessionActivationListener {

    // Public constructor is required by servlet spec
    public DemoHttpSessionActivationListener() {
        System.out.println(">> MyHttpSessionActivationListener - NEW");
    }

    public void sessionWillPassivate(HttpSessionEvent event) {
        System.out.println(">> HttpSession - will passivate, id = " + event.getSession().getId());
    }

    public void sessionDidActivate(HttpSessionEvent event) {
        System.out.println(">> HttpSession - did passivate, id = " + event.getSession().getId());
    }
}
