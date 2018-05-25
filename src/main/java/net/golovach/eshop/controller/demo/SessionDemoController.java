package net.golovach.eshop.controller.demo;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by BELSHINA on 12.02.2017.
 */
public class SessionDemoController extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(true);
//        HttpSession session = request.getSession(false);
        HttpSession session = request.getSession();
        AtomicInteger counter = (AtomicInteger)session.getAttribute("counter");
        if (counter == null) {
            counter = new AtomicInteger(1);
            session.setAttribute("counter", counter);
        }
        int numberOfVisible = counter.getAndIncrement();
        response.getWriter().write("You visit this page: " + numberOfVisible + " time");
    }
}
