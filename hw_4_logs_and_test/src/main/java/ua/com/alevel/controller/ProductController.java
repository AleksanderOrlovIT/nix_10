package ua.com.alevel.controller;


import ua.com.alevel.entity.Product;
import ua.com.alevel.service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductController {

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
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private static void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" : create(reader); break;
            case "2" : update(reader); break;
            case "3" : delete(reader); break;
            case "4" : findByProductId(reader); break;
            case "5" : findAllProducts(); break;
        }
        runNavigation();
    }

    private static void create(BufferedReader reader) {
        System.out.println("ProductController.create");
        try {
            System.out.println("Please, enter Product name");
            String name = reader.readLine();
            System.out.println("Please, enter Product outlay");
            String outlayString = reader.readLine();
            int outlay = Integer.parseInt(outlayString);
            Product product = new Product();
            product.setOutlay(outlay);
            product.setProductName(name);
            ProductService.create(product);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void update(BufferedReader reader) {
        System.out.println("ProductController.update");
        try {
            System.out.println("Please, enter Product id");
            String productId = reader.readLine();
            System.out.println("Please, enter Product name");
            String name = reader.readLine();
            System.out.println("Please, enter Product outlay");
            String outlayString = reader.readLine();
            int outlay = Integer.parseInt(outlayString);
            Product product = new Product();
            product.setProductId(productId);
            product.setOutlay(outlay);
            product.setProductName(name);
            ProductService.update(product);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void delete(BufferedReader reader) {
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

    private static void findAllProducts() {
        System.out.println("ProductController.findAll");
        Product[] products = ProductService.findAllProducts();
        if (products != null && products.length != 0) {
            for (Product product : products) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("products empty");
        }
    }
}
