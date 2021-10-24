package ua.com.alevel.level1;

import java.util.ArrayList;
import java.util.Scanner;

public class ChessHorse {
    public static Scanner sc = new Scanner(System.in);
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Integer> numberList = new ArrayList<>();
    public static ArrayList<String> letterList = new ArrayList<>();

    public static void Application2() {
        int[][] chessBoard = new int[9][8];
        int letter_number = 0, number, decision, count = 1;
        String string_number, string_letter_number;
        for (int i = 0; i < 8; i++) {
            chessBoard[0][i] = i + 1;
        }
        printMethod(chessBoard);
        number = input_number();
        letter_number = input_letter();
        chessBoard[letter_number + 1][number - 1] = 1;
        printMethod(chessBoard);
        do {
            replace_horse_info(number, letter_number);
            System.out.println("");
            System.out.println("If you want to continue programm press 1");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            decision = sc.nextInt();
            if (decision != 1) break;
            chessBoard[letter_number + 1][number - 1] = 0;
            do {
                number = input_number();
                for (int i = 0; i < numberList.size(); i++) {
                    if (number == numberList.get(i)) count--;
                }
                string_number = Integer.toString(number);
                if (count > 0) System.out.println("Please input one of the possible numbers");
            } while (count > 0);
            numberList.clear();
            count++;
            do {
                letter_number = input_letter();
                string_letter_number = Integer.toString(letter_number);
                String full_string=string_number+string_letter_number;
                for (int i = 0; i < letterList.size(); i++) {
                    if(full_string.equals(letterList.get(i))) count--;
                }
                if (count >= 0) System.out.println("Please input one of the possible letters");
            } while (count > 0);
            count++;
            chessBoard[letter_number + 1][number - 1] = 1;
            printMethod(chessBoard);
            letterList.clear();
        } while (decision == 1);
    }

    public static void printMethod(int table[][]) {
        String[] name = {" A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", " "};
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length - 1; j++) {
                System.out.print(table[i][j] + " ");
                if (j == table.length - 2 && i > 0) System.out.print(name[i - 1]);
            }
            System.out.println("");
        }
    }

    public static void replace_horse_info(int number, int letter_number) {
        String[] name = {" A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", " "};
        String temp1, temp2;
        if (number - 2 >= 1) {
            if (letter_number - 1 >= 0) {
                System.out.print(number - 2 + name[letter_number - 1] + " ");
                temp1 = Integer.toString(number - 2);
                temp2 = Integer.toString(letter_number - 1);
                letterList.add(temp1 + temp2);
            }
            if (letter_number + 1 < 8) {
                System.out.print(number - 2 + name[letter_number + 1] + " ");
                temp1 = Integer.toString(number - 2);
                temp2 = Integer.toString(letter_number + 1);
                letterList.add(temp1 + temp2);
            }
            numberList.add(number - 2);
        }
        if (number + 2 <= 8) {
            if (letter_number - 1 >= 0) {
                System.out.print(number + 2 + name[letter_number - 1] + " ");
                temp1 = Integer.toString(number + 2);
                temp2 = Integer.toString(letter_number - 1);
                letterList.add(temp1 + temp2);
            }
            if (letter_number + 1 < 8) {
                System.out.print(number + 2 + name[letter_number + 1] + " ");
                temp1 = Integer.toString(number + 2);
                temp2 = Integer.toString(letter_number + 1);
                letterList.add(temp1 + temp2);
            }
            numberList.add(number + 2);
        }
        if (letter_number - 2 >= 0) {
            if (number - 1 >= 1) {
                System.out.print(number - 1 + name[letter_number - 2] + " ");
                numberList.add(number - 1);
                temp1 = Integer.toString(number - 1);
                temp2 = Integer.toString(letter_number - 2);
                letterList.add(temp1 + temp2);
            }
            if (number + 1 <= 8) {
                System.out.print(number + 1 + name[letter_number - 2] + " ");
                numberList.add(number + 1);
                temp1 = Integer.toString(number + 1);
                temp2 = Integer.toString(letter_number - 2);
                letterList.add(temp1 + temp2);
            }

        }
        if (letter_number + 2 <= 8) {
            if (number - 1 >= 1) {
                System.out.print(number - 1 + name[letter_number + 2] + " ");
                numberList.add(number - 1);
                temp1 = Integer.toString(number - 1);
                temp2 = Integer.toString(letter_number + 2);
                letterList.add(temp1 + temp2);
            }
            if (number + 1 <= 8) {
                System.out.print(number + 1 + name[letter_number + 2] + " ");
                numberList.add(number + 1);
                temp1 = Integer.toString(number + 1);
                temp2 = Integer.toString(letter_number + 2);
                letterList.add(temp1 + temp2);
            }
        }
    }

    public static int input_letter() {
        String line;
        int letter_number = 0;
        System.out.println("Please press vertical letter in upper case where you want to point the horse");
        line = scanner.nextLine();
        if (!line.equals("A") && !line.equals("B") && !line.equals("C") && !line.equals("D") && !line.equals("E")
                && !line.equals("F") && !line.equals("G") && !line.equals("H"))
            throw new RuntimeException("Wrong letter exception");
        if (line.equals("A")) letter_number = 0;
        if (line.equals("B")) letter_number = 1;
        if (line.equals("C")) letter_number = 2;
        if (line.equals("D")) letter_number = 3;
        if (line.equals("E")) letter_number = 4;
        if (line.equals("F")) letter_number = 5;
        if (line.equals("G")) letter_number = 6;
        if (line.equals("H")) letter_number = 7;
        return letter_number;
    }

    public static int input_number() {
        int number;
        System.out.println("Please press horizontal number where you want to point the horse");
        while (!sc.hasNextInt()) {
            sc.next();
        }
        number = sc.nextInt();
        if (number < 1 || number > 9) throw new RuntimeException("NumberOutOfBoundException");
        return number;
    }
}
