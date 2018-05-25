package net.golovach.eshop.dao.impl;

import net.golovach.eshop.dao.ProductDao;
import net.golovach.eshop.dao.exception.DaoSystemException;
import net.golovach.eshop.dao.exception.NoSuchEntityException;
import net.golovach.eshop.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by BELSHINA on 08.02.2017.
 */
public class ProductDaoMock implements ProductDao {
    private final Map<Integer, Product> memory = new ConcurrentHashMap<>();

    public ProductDaoMock() {
        this.memory.put(1, new Product(1, "Bread"));
        this.memory.put(2, new Product(2, "Paper"));
        this.memory.put(3, new Product(3, "Sugar"));
    }

    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException {
        if (!memory.containsKey(id)) {
            throw new NoSuchEntityException("No Product for if == '" + id + "', only");
        }
        return memory.get(id);
    }

    public List<Product> selectAll() throws DaoSystemException {
        return new ArrayList<>(memory.values());
    }
}
