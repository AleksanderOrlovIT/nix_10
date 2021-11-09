package ua.com.alevel.db;

import ua.com.alevel.entity.Product;

import java.util.Arrays;
import java.util.UUID;

public class ProductDB {
    private Product[] products;
    private static ProductDB instance;

    private ProductDB() {
        products = new Product[0];}

    public static ProductDB getInstance() {
        if (instance == null) {
            instance = new ProductDB();
        }
        return instance;
    }

    public void create(Product product) {
        product.setProductId(generateProductId());
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = product;
    }

    private String generateProductId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < products.length; i++)
            if (id.equals(String.valueOf(products[i].getProductId()))) {
                return generateProductId();
            }
        return id;
    }

    public void update(Product product) {
        Product current = findByProductId(product.getProductId());
        current.setProductName(product.getProductName());
        current.setOutlay(product.getOutlay());
    }

    public Product findByProductId(String productId) {
        for (int i = 0; i < products.length; i++) {
            if (productId.equals(String.valueOf(products[i].getProductId()))) return products[i];
            else throw new RuntimeException("factory not found");
        }
        return products[products.length];
    }

    public Product[] findAllProducts() {
        return products;
    }

    public void delete(String productId) {
        Product userToDelete = findByProductId(productId);
        int temp = -1;
        for (int i = 0; i < products.length; i++) {
            if(products[i].getProductId().equals(String.valueOf(userToDelete.getProductId()))){
                products[i] = null;
                temp = i;
            }
        }
        Product tempArray[] = new Product[products.length - 1];
        for (int i = 0; i < temp; i++) {
            tempArray[i] = products[i];
        }
        for (int i = temp; i < tempArray.length; i++) {
            tempArray[i] = products[i+1];
        }
        products = Arrays.copyOf(tempArray, products.length - 1);
    }

    public boolean productExistByName(String factoryName) {
        for (int i = 0; i < products.length; i++) {
            if (factoryName.equals(String.valueOf(products[i].getProductName()))) {
                return true;
            }
        }
        return false;
    }
}
