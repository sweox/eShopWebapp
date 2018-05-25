package net.golovach.eshop.controller;

import net.golovach.eshop.dao.ProductDao;
import net.golovach.eshop.dao.exception.DaoSystemException;
import net.golovach.eshop.dao.exception.NoSuchEntityException;
import net.golovach.eshop.dao.impl.ProductDaoMock;
import net.golovach.eshop.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static java.util.Collections.unmodifiableMap;
import static net.golovach.eshop.controller.SessionAttributes.PRODUCT_IN_BUCKET;

/**
 * Created by BELSHINA on 12.02.2017.
 */
public class ProductAddToBucketController extends HttpServlet {
    public static final String PARAM_ID = "id";
    public static final String PAGE_ERROR = "productAll.do";

    private ProductDao productDao = new ProductDaoMock();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter(PARAM_ID);
        if (idStr != null) {
            try {
                Integer id = Integer.valueOf(idStr);
                Product product = productDao.selectById(id);

                HttpSession session = request.getSession(true);
                Map<Product, Integer> oldBucket = (Map<Product, Integer>) session.getAttribute(PRODUCT_IN_BUCKET);
                if (oldBucket == null) {
                    session.setAttribute(PRODUCT_IN_BUCKET, singletonMap(product, 1));
                } else {
                    Map<Product, Integer> newBucket = new LinkedHashMap<>(oldBucket);
                    if (!newBucket.containsKey(product)) {
                        newBucket.put(product, 1);
                    } else {
                        newBucket.put(product, newBucket.get(product) + 1);
                    }
                    session.setAttribute(PRODUCT_IN_BUCKET, unmodifiableMap(newBucket));
                }
                //OK
                String newLocation = "product.do?id=" + id;
                response.sendRedirect(newLocation);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DaoSystemException ignore) {
                /*NOP*/
            }

        }
        //FAIL
        response.sendRedirect(PAGE_ERROR);
    }
}
