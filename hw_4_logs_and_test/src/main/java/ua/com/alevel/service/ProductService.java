package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.ProductDao;
import ua.com.alevel.entity.Product;

public class ProductService {

    private static final ProductDao productDao = new ProductDao();

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    public static void create(Product product) {
        LOGGER_INFO.info("start create product");
        if (!productDao.existByFactoryName(product.getProductName())) {
            productDao.create(product);
        } else {
            LOGGER_WARN.warn("Product name has already existed");
            System.out.println("Product name has already existed");
        }
    }

    public static void update(Product product) {
        LOGGER_INFO.info("start update product");
        productDao.update(product);
    }

    public static void delete(String productId) {
        LOGGER_INFO.info("start delete product");
        productDao.delete(productId);
    }

    public static Product findByProductId(String productId) {
        return productDao.findByProductId(productId);
    }

    public static Product[] findAllProducts() {
        return productDao.findAll();
    }

    public static String giveTypeByProductId(String productId){
        return productDao.giveTypeByProductId(productId);
    }

    public static int getOutlay(String productId) {
        return productDao.getOutlay(productId);}
}
