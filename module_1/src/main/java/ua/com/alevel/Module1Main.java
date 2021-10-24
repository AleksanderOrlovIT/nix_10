package ua.com.alevel;

import java.util.Scanner;

import static ua.com.alevel.level1.ChessHorse.Application2;
import static ua.com.alevel.level1.TriangleArea.Application3;
import static ua.com.alevel.level1.UniqueNumbers.Application1;

public class Module1Main {
    public static void main(String[] args) {
        int programmTemp=1,levelTemp,application_temp;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Please decide what level you want from 1 to 3");
            while(!sc.hasNextInt()){
                sc.next();
            }
            levelTemp = sc.nextInt();
            switch (levelTemp){
                case 1:
                    System.out.println("Please choose exercise from 1 to 3");
                    while(!sc.hasNextInt()){
                        sc.next();
                    }
                    application_temp = sc.nextInt();
                    switch (application_temp){
                        case 1:Application1();
                        break;
                        case 2:Application2();
                        break;
                        case 3:Application3();
                        break;
                        default:System.out.println("Please input correct number from 1 to 3 next time");
                    }
                    break;
                case 2:
                case 3:
                default:
                    System.out.println("Please input correct number from 1 to 3 next time");
            }
            System.out.println("If you want to continue application press 1 otherwise press any other button");
        }while(programmTemp==1);
    }
}
