package net.golovach.eshop.entity;

/**
 * Created by BELSHINA on 08.02.2017.
 */
public class Product {
    private final int id;
    private final String productName;


    public Product(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return productName;
    }

    public String toString() {
        return "Product{" + "id=" + id +
                ", productName='" + productName + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        return productName != null ? productName.equals(product.productName) : product.productName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }
}
