package ua.com.alevel.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Factory;
import ua.com.alevel.entity.Product;
import ua.com.alevel.service.FactoryService;
import ua.com.alevel.service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductController {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");

    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    return;
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void  runNavigation() {
        System.out.println();
        System.out.println("if you want create Product, please enter 1");
        System.out.println("if you want update Product, please enter 2");
        System.out.println("if you want delete Product, please enter 3");
        System.out.println("if you want findByProductId Product, please enter 4");
        System.out.println("if you want findAllProducts Product, please enter 5");
        System.out.println("if you want showProductFactories Product, please enter 6");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private static void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" : create(reader); break;
            case "2" : update(reader); break;
            case "3" : delete(reader); break;
            case "4" : findByProductId(reader); break;
            case "5" : findAllProducts(); break;
            case "6" : showProductFactories(reader);
        }
        runNavigation();
    }

    private static void create(BufferedReader reader) {
        System.out.println("ProductController.create");
        try {
            System.out.println("Please, enter Product name");
            String name = reader.readLine();
            System.out.println("Please, enter Product type");
            String type = reader.readLine();
            System.out.println("Please, enter Product outlay");
            String outlayString = reader.readLine();
            int outlay = Integer.parseInt(outlayString);
            Product product = new Product();
            product.setOutlay(outlay);
            product.setProductType(type);
            product.setProductName(name);
            ProductService.create(product);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void update(BufferedReader reader) {
        findAllProducts();
        System.out.println("ProductController.update");
        try {
            System.out.println("Please, enter Product id");
            String productId = reader.readLine();
            System.out.println("Please, enter Product name");
            String name = reader.readLine();
            System.out.println("Please, enter Product type");
            String type = reader.readLine();
            System.out.println("Please, enter Product outlay");
            String outlayString = reader.readLine();
            int outlay = Integer.parseInt(outlayString);
            Product product = new Product();
            product.setProductId(productId);
            product.setProductName(name);
            product.setProductType(type);
            product.setOutlay(outlay);
            ProductService.update(product);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void delete(BufferedReader reader) {
        findAllProducts();
        System.out.println("ProductController.delete");
        try {
            System.out.println("Please, enter Product id");
            String productId = reader.readLine();
            ProductService.delete(productId);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void findByProductId(BufferedReader reader) {
        findAllProducts();
        System.out.println("ProductController.findById");
        try {
            System.out.println("Please, enter Factory id");
            String productId = reader.readLine();
            Product product = ProductService.findByProductId(productId);
            System.out.println("Product = " + product);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    public static Product[] findAllProducts() {
        System.out.println("ProductController.findAll");
        Product[] products = ProductService.findAllProducts();
        if (products != null && products.length != 0) {
            for (Product product : products) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("products empty");
        }
        return products;
    }

    public static Product[] findAllProductsForStorage(){
        Product[] products = ProductService.findAllProducts();
        if (products != null && products.length != 0) {
        } else {
            System.out.println("products empty");
        }
        return products;
    }

    private static void showProductFactories(BufferedReader reader) throws IOException {
        System.out.println("ProductController.showProductFactories");
        int count = 0;
        Factory[] factories = FactoryController.findAllFactoriesForStorage();
        String productId = reader.readLine();
        String productType = ProductService.giveTypeByProductId(productId);
        int outlay = ProductService.getOutlay(productId);
        for(int i=0; i<factories.length; i++){
            int capacity = factories[i].getCapacity();
            if(factories[i].getFactoryType().equals(productType) && outlay <= capacity) {
                LOGGER_INFO.info("Searching the same type Factories with proper capacity for Product by id"
                        + productId);
                System.out.println(factories[i].getFactoryName());
                count++;
            }
        }
        LOGGER_INFO.info("There are no Factories with proper capacity for product");
        if(count == 0) System.out.println("No factories are producing this product");
    }
}
