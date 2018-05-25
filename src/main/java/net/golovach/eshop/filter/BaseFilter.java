package net.golovach.eshop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by BELSHINA on 07.02.2017.
 */
public abstract class BaseFilter implements Filter {

    public BaseFilter() {
        System.out.println(">> BaseFilter - NEW");
    }

    //@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //NOP
        System.out.println(">> baseFilter init");
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        doFilter((HttpServletRequest) request, (HttpServletResponse) response,
                chain);
    }

    public abstract void doFilter(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain chain) throws IOException, ServletException;

    public void destroy() {
        //NOP
    }
}
