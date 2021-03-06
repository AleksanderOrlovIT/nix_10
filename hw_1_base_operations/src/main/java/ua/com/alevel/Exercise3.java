package ua.com.alevel;

import java.util.Scanner;

class Exercise3 {
    public static void calculateTime() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a number from 1 to 10 to find out when the lesson ends--> ");
        int lesson;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("That not an integer number!");
                sc.next();
            }
            lesson = sc.nextInt();
            if(lesson <= 0 || lesson > 10) System.out.println("Please input a number from 1 to 10");
        } while (lesson <= 0 || lesson > 10);
        lesson = lesson * 45 + (lesson / 2) * 5 + ((lesson + 1) / 2 - 1) * 15;
        int hours = lesson / 60 + 9;
        int minutes = lesson % 60;
        System.out.println("The lesson will end at " + hours + " hours");
        System.out.println("and " + minutes + " minutes");
    }
}