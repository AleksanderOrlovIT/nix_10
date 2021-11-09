package ua.com.alevel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {
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
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void runNavigation() {
        System.out.println();
        System.out.println("if you want to change Factories, please enter 1");
        System.out.println("if you want to change Products, please enter 2");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private static void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                FactoryController.run();
                break;
            case "2":
                ProductController.run();
                break;
        }
        runNavigation();
    }
}
