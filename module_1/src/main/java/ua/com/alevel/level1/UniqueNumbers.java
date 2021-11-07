package ua.com.alevel.level1;

import java.util.ArrayList;
import java.util.Scanner;

public class UniqueNumbers {

    public static void uniqueNumbersMain() {
        int temp;
        do {
            int count0 = 0, count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0;
            Scanner sc = new Scanner(System.in);
            ArrayList<Integer> myList = new ArrayList<>();
            System.out.println("Please input line to count unique numbers in it");
            String line = sc.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    myList.add(Character.getNumericValue(line.charAt(i)));
                }
            }

            for (int i = 0; i < myList.size(); i++) {
                if (count0 == 0 && myList.get(i) == 0) count0 = 1;
                if (count1 == 0 && myList.get(i) == 1) count1 = 1;
                if (count2 == 0 && myList.get(i) == 2) count2 = 1;
                if (count3 == 0 && myList.get(i) == 3) count3 = 1;
                if (count4 == 0 && myList.get(i) == 4) count4 = 1;
                if (count5 == 0 && myList.get(i) == 5) count5 = 1;
                if (count6 == 0 && myList.get(i) == 6) count6 = 1;
                if (count7 == 0 && myList.get(i) == 7) count7 = 1;
                if (count8 == 0 && myList.get(i) == 8) count8 = 1;
                if (count9 == 0 && myList.get(i) == 9) count9 = 1;
            }
            System.out.println(count0 + count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9);
            System.out.println("If you want to restart UniqueNumbers application" +
                    " press 1 otherwise press any other number");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            temp = sc.nextInt();
        } while (temp == 1);
    }
}
