package ua.com.alevel;

import ua.com.alevel.level3.GameOfLife;

import java.util.Scanner;

import static ua.com.alevel.level1.ChessHorse.ChessHorseMain;
import static ua.com.alevel.level1.TriangleArea.TriangleAreaMain;
import static ua.com.alevel.level1.UniqueNumbers.UniqueNumbersMain;
import static ua.com.alevel.level2.BinaryTree.BinaryTree.BinaryTreeMain;
import static ua.com.alevel.level2.CorrectBrackets.CorrectBracketsMain;
import static ua.com.alevel.level3.GameOfLife.GameOfLifeMain;

public class Module1Main {
    public static void main(String[] args) {
        int programmTemp,levelTemp,application_temp;
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
                        case 1:
                            UniqueNumbersMain();
                        break;
                        case 2:
                            ChessHorseMain();
                        break;
                        case 3:
                            TriangleAreaMain();
                        break;
                        default:System.out.println("Please input correct number from 1 to 3 next time");
                    }
                    break;
                case 2:
                    System.out.println("Please choose exercise from 1 to 2");
                    while(!sc.hasNextInt()){
                        sc.next();
                    }
                    application_temp = sc.nextInt();
                    switch (application_temp) {
                        case 1:
                            CorrectBracketsMain();
                            break;
                        case 2:
                            BinaryTreeMain();
                            break;
                        default:System.out.println("Please input correct number from 1 to 2 next time");
                    }
                    break;
                case 3:
                    GameOfLifeMain();
                    break;
                default:System.out.println("Please input correct number from 1 to 3 next time");
            }
            System.out.println("If you want to continue application press 1 otherwise press any other number");
            while(!sc.hasNextInt()){
                sc.next();
            }
            programmTemp = sc.nextInt();
        }while(programmTemp==1);
    }

}
