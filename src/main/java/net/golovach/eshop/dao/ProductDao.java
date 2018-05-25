package net.golovach.eshop.dao;

import net.golovach.eshop.dao.exception.DaoSystemException;
import net.golovach.eshop.dao.exception.NoSuchEntityException;
import net.golovach.eshop.entity.Product;

import java.util.List;

/**
 * Created by BELSHINA on 08.02.2017.
 */
public interface ProductDao {

    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException;

    public List<Product> selectAll() throws DaoSystemException;
}
