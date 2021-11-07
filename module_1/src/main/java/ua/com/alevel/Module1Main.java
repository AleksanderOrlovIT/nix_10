package ua.com.alevel;

import java.util.Scanner;

import static ua.com.alevel.level1.ChessHorse.chessHorseMain;
import static ua.com.alevel.level1.TriangleArea.triangleAreaMain;
import static ua.com.alevel.level1.UniqueNumbers.uniqueNumbersMain;
import static ua.com.alevel.level2.binarytree.BinaryTree.binaryTreeMain;
import static ua.com.alevel.level2.CorrectBrackets.CorrectBracketsMain;
import static ua.com.alevel.level3.GameOfLife.gameOfLifeMain;

public class Module1Main {

    public static void main(String[] args) {
        int programmTemp, levelTemp, applicationTemp;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please decide what level you want from 1 to 3");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            levelTemp = sc.nextInt();
            switch (levelTemp) {
                case 1:
                    System.out.println("Please choose exercise from 1 to 3");
                    while (!sc.hasNextInt()) {
                        sc.next();
                    }
                    applicationTemp = sc.nextInt();
                    switch (applicationTemp) {
                        case 1:
                            uniqueNumbersMain();
                            break;
                        case 2:
                            chessHorseMain();
                            break;
                        case 3:
                            triangleAreaMain();
                            break;
                        default:
                            System.out.println("Please input correct number from 1 to 3 next time");
                    }
                    break;
                case 2:
                    System.out.println("Please choose exercise from 1 to 2");
                    while (!sc.hasNextInt()) {
                        sc.next();
                    }
                    applicationTemp = sc.nextInt();
                    switch (applicationTemp) {
                        case 1:
                            CorrectBracketsMain();
                            break;
                        case 2:
                            binaryTreeMain();
                            break;
                        default:
                            System.out.println("Please input correct number from 1 to 2 next time");
                    }
                    break;
                case 3:
                    gameOfLifeMain();
                    break;
                default:
                    System.out.println("Please input correct number from 1 to 3 next time");
            }
            System.out.println("If you want to continue application press 1 otherwise press any other number");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            programmTemp = sc.nextInt();
        } while (programmTemp == 1);
    }

}
