package net.golovach.eshop.listener.demo; /**
 * Created by BELSHINA on 07.02.2017.
 */

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class DemoHttpSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public DemoHttpSessionListener() {
    }



    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent event) {
      /* Session is created. */

    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent event) {
      /* This method is called when an attribute 
         is added to a session.
      */
        //System.out.println(">> HttpSessionBining" + event.getName());
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
