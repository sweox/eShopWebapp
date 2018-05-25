package net.golovach.eshop.controller;

import net.golovach.eshop.dao.ProductDao;
import net.golovach.eshop.dao.exception.DaoSystemException;
import net.golovach.eshop.dao.exception.NoSuchEntityException;
import net.golovach.eshop.dao.impl.ProductDaoMock;
import net.golovach.eshop.entity.Product;
import net.golovach.eshop.inject.DependencyInjectionServlet;
import net.golovach.eshop.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 31.01.2017.
 */
public class ProductController extends DependencyInjectionServlet {
    public static final String PARAM_ID = "id";
    public static final String ATTRIBUTE_MODEL_TO_VIEW = "product";
    public static final String PAGE_OK = "product.jsp";
    public static final String PAGE_ERROR = "error.jsp";
//название productDao дублируется случайно
    @Inject("productDao")
//    @Inject(value="productDao", age=5)
//    @Inject(name="productDao")
//    @Inject(name="productDao", authors = {"Anna", "Mike")
    private ProductDao productDao;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String idSTR = request.getParameter(PARAM_ID);
        if (idSTR != null) {
            try {
                System.out.println("В try ProductController!!!!!!!!!!!!!!!!!!!!!");
                Integer id = Integer.valueOf(idSTR);
                Product model = productDao.selectById(id);
                request.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
                // OK
                System.out.println("В try ProductController 222!!!!!!!!!!!!!!!!!!!!!");

                request.getRequestDispatcher(PAGE_OK).forward(request, response);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DaoSystemException e) {
                /*NOP*/
            }
        }
        //FAIL
        response.sendRedirect(PAGE_ERROR);
    }
}
