package ua.com.alevel;

import java.util.Arrays;
import java.util.Scanner;

public class StringsMain {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int application_temp, variant;
        do {
            System.out.println("If you want to start application press 1, if tou want to exit press any other button");
            application_temp = sc.nextInt();
            if (application_temp != 1) break;
            System.out.println("Please choose what a number from 1 to 3.\n If you want reverse full line press 1.\n" +
                    " If you want to reverse by substring in line press 2\n If you want to reverse by index press 3");
            variant = sc.nextInt();
            switch (variant) {
                case 1:
                    first_application();
                    break;
                case 2:
                    second_application();
                    break;
                case 3:
                    third_application();
                    break;
                default:
                    System.out.println("Please input correct number next time");
            }
        } while (application_temp == 1);
    }

    private static void first_application() {
        System.out.println("Please input the line you want to be reversed");
        String line = sc.nextLine();
        line = StringReverseUtil.full_reverse(line);
        System.out.println(line);
    }

    private static void second_application() {
        System.out.println("Please input the line");
        String line = sc.nextLine();
        System.out.println("Please input the part");
        String part = sc.nextLine();
        line = StringReverseUtil.substring_reverse(line, part);
        System.out.println(line);
    }

    private static void third_application() throws Exception {
        System.out.println("Please input the line");
        String line = sc.nextLine();
        System.out.println("Please input the left index");
        int left = sc.nextInt();
        if (left >= line.length() || left < 0) throw new Exception("Left index is not appropriate");
        System.out.println("Please input the right index");
        int right = sc.nextInt();
        if (right >= line.length() || right < 0) throw new Exception("Right index is not appropriate");
        if (left > right) throw new Exception("Left more than right");
        line = StringReverseUtil.index_reverse(line, left, right);
        System.out.println(line);
    }
}
