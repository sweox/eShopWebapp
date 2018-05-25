package net.golovach.eshop.controller.demo;

import net.golovach.eshop.entity.demo.DemoEntityA;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by BELSHINA on 08.02.2017.
 */
//Атрибуты можно установить в 4 разных местах
public class MVCDemoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //add to REQUEST attributes
        request.setAttribute("requestAttribute", new DemoEntityA());
        //add to SESSION attributes
        HttpSession session = request.getSession();
        session.setAttribute("sessionAttribute",new DemoEntityA());
        //add to SERVLET_CONTEXT attributes
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("servletContextAttribute", new DemoEntityA());

        //request.setAttribute("test", "request");
        request.getSession().setAttribute("test", "session");
        request.getServletContext().setAttribute("test", "servletContext");

        request.getRequestDispatcher("mvcMockView.jsp").forward(request, response);
    }
}
