package net.golovach.eshop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by BELSHINA on 02.02.2017.
 */
public class RequestInfoFilter extends BaseFilter {

    public RequestInfoFilter() {
        System.out.println(">> RequestInfoFilter - NEW");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String method = request.getMethod();
        String remoteAddr = request.getRemoteAddr();
        String queryString = request.getQueryString();
        String protocol = request.getProtocol();
        System.out.println(">> RequestInfoFilter: " + request + "\r\n" +
                ", Method: " + method + "\r\n" +
                ", RemoteAddress: " + remoteAddr + "\r\n" +
                ", QueryString: " + queryString + "\r\n" +
                ", Protocol: "+ protocol);
        System.out.println();

        chain.doFilter(request, response);

//        response.sendRedirect("dsfsdfsd");
    }

}
