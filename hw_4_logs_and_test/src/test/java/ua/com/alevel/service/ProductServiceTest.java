package ua.com.alevel.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.entity.Product;

public class ProductServiceTest {
    private ProductService productService = new ProductService();
    private static final String RANDOM_NAME= "RandomProduct";
    private static final String RANDOM_TYPE= "RandomType";


    @Test
    @Order(1)
    public void createProduct(){
        int randomNumber = (int)Math.random() * 15;
        Product[] factories = new Product[randomNumber];
        for(int i=0; i<randomNumber; i++) {
            Product factory = new Product();
            factory.setProductName(RANDOM_NAME + i);
            factory.setProductType(RANDOM_TYPE + i);
            factory.setOutlay(i);
            factories[i] = factory;
        }
        Assertions.assertEquals(factories.length, randomNumber);
    }

    @Test
    @Order(2)
    public void updateProduct(){
        Product product = new Product();
        product.setProductName("qwe");
        product.setProductType("asd");
        product.setOutlay(1);
        productService.create(product);
        productService.update(product);
        product.setProductId(product.getProductId());
        product.setProductName("name");
        product.setProductType("type");
        product.setOutlay(2);
        Assertions.assertEquals(product.getProductName(), "name");
        Assertions.assertEquals(product.getProductType(), "type");
        Assertions.assertEquals(product.getOutlay(), 2);
    }


    @Test
    @Order(3)
    public void findProductType(){
        Product product = generateRandomProduct();
        productService.create(product);
        String productId = product.getProductId();
        productService.giveTypeByProductId(productId);
        Assertions.assertEquals(product.getProductType(), RANDOM_TYPE );
    }

    @Test
    @Order(4)
    public void getOutlay(){
        Product product = new Product();
        product.setProductName("google");
        product.setProductType("fish");
        product.setOutlay(1);
        productService.create(product);
        String productId = product.getProductId();
        int outlay = productService.getOutlay(productId);
        Assertions.assertEquals(outlay, product.getOutlay());
    }


    private static Product generateRandomProduct() {
        Product product = new Product();
        product.setProductName(RANDOM_NAME);
        product.setProductType(RANDOM_TYPE);
        product.setOutlay(1);
        return product;
    }
}
