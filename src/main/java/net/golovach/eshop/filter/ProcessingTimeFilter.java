package net.golovach.eshop.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by BELSHINA on 02.02.2017.
 */
public class ProcessingTimeFilter implements Filter {

    public ProcessingTimeFilter() {
        System.out.println(">> ProcessingTimeFilter - NEW");
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">> ProcessingTimeFilter - init");
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        long inTime = System.nanoTime();
        chain.doFilter(request, response);
        long outTime = System.nanoTime();
    System.out.println(">> ProcessingTimeFilter: dt = " + (outTime - inTime));
    System.out.println();
    }

    public void destroy() {
        System.out.println(">> ProcessingTimeFilter - destroy");
    }


}
