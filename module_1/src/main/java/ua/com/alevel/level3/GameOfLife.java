package ua.com.alevel.level3;

import java.util.Scanner;

public class GameOfLife {

    static int[][] array;
    static int[][] next_array;
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void gameOfLifeMain() {
        int restart_programm;
        do {
            int line, column, repeat_action, change_element, zero_or_one_element;
            int random_or_hand, runGameDecision, runGameCount;
            System.out.println("Please type what matrix size do you want");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            line = sc.nextInt();
            column = line;
            array = new int[line][column];
            System.out.println("If you want to random elements press any number, " +
                    "if you want to type all elements by yourself press 0");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            random_or_hand = sc.nextInt();
            if (random_or_hand == 0) handFill(array, line, column);
            if (random_or_hand != 0) randomFill(array, line, column);
            System.out.println("Original Generation");
            printArray(array, line, column);
            System.out.println();
            do {
                nextGeneration(array, line, column);
                System.out.println("If you want to change element press 1");
                while (!sc.hasNextInt()) {
                    sc.next();
                }
                change_element = sc.nextInt();
                if (change_element == 1) {
                    do {
                        System.out.println("If you want to add . element press 0, if you want to add * element press 1");
                        while (!sc.hasNextInt()) {
                            sc.next();
                        }
                        zero_or_one_element = sc.nextInt();
                        if (zero_or_one_element == 0)
                            changeArrayToZero(next_array);
                        else if (zero_or_one_element == 1)
                            changeArrayToOne(next_array);
                        System.out.println("If you want to change more elements press 1");
                        while (!sc.hasNextInt()) {
                            sc.next();
                        }
                        change_element = sc.nextInt();
                    } while (change_element == 1);
                    System.out.println("ChangedArray:");
                    printArray(next_array, line, column);
                }
                System.out.println("If you want to show the next generations non-stop press 1");
                while (!sc.hasNextInt()) {
                    sc.next();
                }
                runGameDecision = sc.nextInt();
                if (runGameDecision == 1) {
                    System.out.println("Please type how many times you want to see the next generations");
                    while (!sc.hasNextInt()) {
                        sc.next();
                    }
                    runGameCount = sc.nextInt();
                    for (int i = 0; i < runGameCount; i++) {
                        nextGeneration(array, line, column);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("If you want to see the next generation press 1");
                while (!sc.hasNextInt()) {
                    sc.next();
                }
                repeat_action = sc.nextInt();
            } while (repeat_action == 1);
            System.out.println("If you want to restart the GameOfLife press 1");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            restart_programm = sc.nextInt();
        } while (restart_programm == 1);
    }


    static void nextGeneration(int[][] array, int line, int column) {
        int alive_Neighbours;
        if (count != 0) array = next_array;
        count++;
        next_array = new int[line][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                alive_Neighbours = checkNeighbours(array, i, j);
                if ((array[i][j] == 1) && (alive_Neighbours < 2))
                    next_array[i][j] = 0;
                else if ((array[i][j] == 1) && (alive_Neighbours > 3))
                    next_array[i][j] = 0;
                else if ((array[i][j] == 0) && (alive_Neighbours == 3))
                    next_array[i][j] = 1;
                else
                    next_array[i][j] = array[i][j];
            }
        }
        System.out.println("Next Generation");
        printArray(next_array, line, column);
    }

    public static void randomFill(int[][] array, int line, int column) {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = (int) Math.round(Math.random());
            }
        }
    }

    public static void printArray(int[][] array, int line, int column) {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                if (array[i][j] == 0)
                    System.out.print(". ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void changeArrayToZero(int[][] array) {
        int restart_number;
        do {
            int line, column;
            System.out.println("Please type element`s line number");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            line = sc.nextInt();
            System.out.println("Please type element`s column number");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            column = sc.nextInt();
            array[line][column] = 0;
            System.out.println("If you want to add one more . element press 1");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            restart_number = sc.nextInt();
        } while (restart_number == 1);
    }

    public static void changeArrayToOne(int[][] array) {
        int restart_number;
        do {
            int line, column;
            System.out.println("Please type element`s line number");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            line = sc.nextInt();
            System.out.println("Please type element`s column number");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            column = sc.nextInt();
            array[line][column] = 1;
            System.out.println("If you want to add one more * element press 1");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            restart_number = sc.nextInt();
        } while (restart_number == 1);
    }

    public static int checkNeighbours(int[][] array, int line, int column) {
        int count_neighbours = 0;
        if (column - 1 >= 0) {
            if (array[line][column - 1] == 1) count_neighbours++;
        }
        if (column + 1 < array.length) {
            if (array[line][column + 1] == 1) count_neighbours++;
        }
        if (line - 1 >= 0) {
            if (array[line - 1][column] == 1) count_neighbours++;
            if (column - 1 >= 0) {
                if (array[line - 1][column - 1] == 1) count_neighbours++;
            }
            if (column + 1 < array.length) {
                if (array[line - 1][column + 1] == 1) count_neighbours++;
            }
        }
        if (line + 1 < array.length) {
            if (array[line + 1][column] == 1) count_neighbours++;
            if (column - 1 >= 0) {
                if (array[line + 1][column - 1] == 1) count_neighbours++;
            }
            if (column + 1 < array.length) {
                if (array[line + 1][column + 1] == 1) count_neighbours++;
            }
        }
        return count_neighbours;
    }

    public static void handFill(int[][] array, int line, int column) {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println("Please input element on line=" + i + "column=" + j);
                while (!sc.hasNextInt()) {
                    sc.next();
                }
                int temp = sc.nextInt();
                if (temp != 0 && temp != 1) array[i][j] = 0;
                else array[i][j] = temp;
            }
        }
    }
}
