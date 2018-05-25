package net.golovach.eshop.controller.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by BELSHINA on 02.02.2017.
 */
//@WebServlet("/moc.do")
//@WebServlet(urlPatterns = {"/moc.do"})
public class DemoController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher page = request.getRequestDispatcher("mock.do");
//        page.forward(request, response);

        response.getWriter().write("Hello from servlet!\r\n");
        response.getWriter().write("Hello from servlet!\r\n");
        response.getWriter().write("<br></br>");
        response.getWriter().write("Hello from servlet!\r\n");
        //response.getWriter().write(response.getHeaderNames().size());

    }
}
