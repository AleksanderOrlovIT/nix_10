package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Factory;
import ua.com.alevel.entity.Product;
import ua.com.alevel.service.FactoryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryController {

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

    private static void runNavigation() {
        System.out.println();
        System.out.println("if you want create Factory, please enter 1");
        System.out.println("if you want update Factory, please enter 2");
        System.out.println("if you want delete Factory, please enter 3");
        System.out.println("if you want findByFactoryId Factory, please enter 4");
        System.out.println("if you want findAllFactories Factory, please enter 5");
        System.out.println("if you want showFactoriesProduct Factory, please enter 6");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private static void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" : create(reader); break;
            case "2" : update(reader); break;
            case "3" : delete(reader); break;
            case "4" : findByFactoryId(reader); break;
            case "5" : findAllFactories(); break;
            case "6" : showFactoriesProduct(reader); break;
        }
        runNavigation();
    }

    private static void create(BufferedReader reader) {
        System.out.println("FactoryController.create");
        try {
            System.out.println("Please, enter Factory name");
            String name = reader.readLine();
            System.out.println("Please, enter Factory type");
            String factoryType = reader.readLine();
            System.out.println("Please, enter Factory capacity");
            String capacityString = reader.readLine();
            int capacity = Integer.parseInt(capacityString);
            Factory factory = new Factory();
            factory.setCapacity(capacity);
            factory.setFactoryName(name);
            factory.setFactoryType(factoryType);
            FactoryService.create(factory);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void update(BufferedReader reader) {
        findAllFactories();
        System.out.println("FactoryController.update");
        try {
            System.out.println("Please, enter Factory id");
            String factoryId = reader.readLine();
            System.out.println("Please, enter Factory name");
            String name = reader.readLine();
            System.out.println("Please, enter Factory type");
            String type = reader.readLine();
            System.out.println("Please, enter Factory capacity");
            String capacityString = reader.readLine();
            int capacity = Integer.parseInt(capacityString);
            Factory factory = new Factory();
            factory.setFactoryId(factoryId);
            factory.setFactoryName(name);
            factory.setFactoryType(type);
            factory.setCapacity(capacity);
            FactoryService.update(factory);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void delete(BufferedReader reader) {
        findAllFactories();
        System.out.println("FactoryController.delete");
        try {
            System.out.println("Please, enter Factory id");
            String factoryId = reader.readLine();
            FactoryService.delete(factoryId);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void findByFactoryId(BufferedReader reader) {
        findAllFactories();
        System.out.println("FactoryController.findById");
        try {
            System.out.println("Please, enter Factory id");
            String factoryId = reader.readLine();
            Factory factory = FactoryService.findByFactoryId(factoryId);
            System.out.println("Factory = " + factory);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    public static Factory[] findAllFactories() {
        System.out.println("FactoryController.findAll");
        Factory[] factories = FactoryService.findAllFactories();
        if (factories != null && factories.length != 0) {
            for (Factory factory : factories) {
                System.out.println(factory.toString());
            }
        } else {
            System.out.println("factories empty");
        }
        return factories;
    }

    public static Factory[] findAllFactoriesForStorage(){
        Factory[] factories = FactoryService.findAllFactories();
        if (factories != null && factories.length != 0) {
        } else {
            System.out.println("factories empty");
        }
        return factories;
    }

    public static void showFactoriesProduct(BufferedReader reader) throws IOException {
        System.out.println("FactoryController.showFactoriesProduct");
        int count = 0;
        Product[] products = ProductController.findAllProductsForStorage();
        String factoryId = reader.readLine();
        String factoryType = FactoryService.giveTypeByFactoryId(factoryId);
        int capacity = FactoryService.getCapacity(factoryId);
        int old_capacity = capacity;
        for(int i=0; i<products.length; i++){
            int outlay = products[i].getOutlay();
            if(products[i].getProductType().equals(factoryType) && capacity>=outlay){
                LOGGER_INFO.info("Searching the same type Products with proper outlay for Factory by id" + factoryId);
                capacity = FactoryService.changeCapacity(factoryId, outlay);
                System.out.println(products[i].getProductName());
            }
            count++;
        }
        FactoryService.returnCapacity(factoryId,old_capacity);
        LOGGER_INFO.info("There are no products with the same type and proper outlay as Factory has");
        if(count == 0) System.out.println("Factory isn`t producing any products");
    }
}
