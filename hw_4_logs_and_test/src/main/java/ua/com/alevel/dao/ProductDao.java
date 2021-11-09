package ua.com.alevel.dao;

import ua.com.alevel.db.ProductDB;
import ua.com.alevel.entity.Product;

public class ProductDao {
    public void create(Product product) {
        ProductDB.getInstance().create(product);
    }

    public void update(Product product) {
        ProductDB.getInstance().update(product);
    }

    public void delete(String productId) {ProductDB.getInstance().delete(productId);}

    public Product findByProductId(String productId) { return ProductDB.getInstance().findByProductId(productId); }

    public Product[] findAll() { return ProductDB.getInstance().findAllProducts(); }

    public boolean existByFactoryName(String productName) {
        return ProductDB.getInstance().productExistByName(productName);
    }
}
