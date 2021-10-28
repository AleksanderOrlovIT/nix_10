package ua.com.alevel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        Exercise2 exercise2 = new Exercise2();
        Exercise3 exercise3 = new Exercise3();
        Scanner sc = new Scanner(System.in);
        int application_temp,variant_number;
        do{
            System.out.println("If you want to start application type any integer number, if you want to exit press 0");
            while (!sc.hasNextInt()) {
                System.out.println("That`s not an integer number!");
                sc.next();
            }
            application_temp = sc.nextInt();
            if(application_temp ==0) break;
            System.out.println("Please choose what exercise from 1 to 3 you want");
            while (!sc.hasNextInt()) {
                System.out.println("That`s not an integer number!");
                sc.next();
            }
            variant_number = sc.nextInt();
            switch (variant_number){
                case(1):
                    exercise1.findNumber();
                    break;
                case(2):
                    exercise2.findLetters();
                    break;
                case(3):
                    exercise3.calculateTime();
                    break;
                default:
                    System.out.println("Please next time choose number from 1 to 3");
            }

        }while(application_temp!=0);
    }
}
