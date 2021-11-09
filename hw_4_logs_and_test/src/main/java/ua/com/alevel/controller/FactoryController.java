package ua.com.alevel.controller;

import ua.com.alevel.dao.FactoryDao;
import ua.com.alevel.entity.Factory;
import ua.com.alevel.service.FactoryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryController {

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
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private static void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" : create(reader); break;
            case "2" : update(reader); break;
            case "3" : delete(reader); break;
            case "4" : findByFactoryId(reader); break;
            case "5" : findAllFactories(); break;
        }
        runNavigation();
    }

    private static void create(BufferedReader reader) {
        System.out.println("FactoryController.create");
        try {
            System.out.println("Please, enter Factory name");
            String name = reader.readLine();
            System.out.println("Please, enter Factory capacity");
            String capacityString = reader.readLine();
            int capacity = Integer.parseInt(capacityString);
            Factory factory = new Factory();
            factory.setCapacity(capacity);
            factory.setFactoryName(name);
            FactoryService.create(factory);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void update(BufferedReader reader) {
        System.out.println("FactoryController.update");
        try {
            System.out.println("Please, enter Factory id");
            String factoryId = reader.readLine();
            System.out.println("Please, enter Factory name");
            String name = reader.readLine();
            System.out.println("Please, enter Factory capacity");
            String capacityString = reader.readLine();
            int capacity = Integer.parseInt(capacityString);
            Factory factory = new Factory();
            factory.setFactoryId(factoryId);
            factory.setCapacity(capacity);
            factory.setFactoryName(name);
            FactoryService.update(factory);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void delete(BufferedReader reader) {
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

    private static void findAllFactories() {
        System.out.println("FactoryController.findAll");
        Factory[] factories = FactoryService.findAllFactories();
        if (factories != null && factories.length != 0) {
            for (Factory factory : factories) {
                System.out.println(factory.toString());
            }
        } else {
            System.out.println("factories empty");
        }
    }
}
