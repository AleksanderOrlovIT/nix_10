package ua.com.alevel.service;

import ua.com.alevel.dao.ProductDao;
import ua.com.alevel.entity.Product;

public class ProductService {

    private static final ProductDao productDao = new ProductDao();

    public static void create(Product product) {
        if (!productDao.existByFactoryName(product.getProductName())) {
            productDao.create(product);
        } else {
            System.out.println("Product name has already existed");
        }
    }

    public static void update(Product product) {
        productDao.update(product);
    }

    public static void delete(String productId) {
        productDao.delete(productId);
    }

    public static Product findByProductId(String productId) {
        return productDao.findByProductId(productId);
    }

    public static Product[] findAllProducts() {
        return productDao.findAll();
    }
}
