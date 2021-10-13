package ua.com.alevel;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Exercise2{
    public static void findLetters() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input line to calculate how many letters it has:");
        char[] array = sc.nextLine().toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            char temp = array[i];
            if(Character.isLetter(temp)) {
                int count = 0;
                for (int j = 0; j < array.length; j++) {
                    if (temp == array[j]) {
                        count++;
                    }
                }
                map.put(temp, count);
            }
        }
        System.out.println(map.toString());
    }
}
