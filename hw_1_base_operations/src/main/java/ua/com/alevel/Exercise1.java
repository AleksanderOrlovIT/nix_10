package ua.com.alevel;
import java.util.Scanner;

class Exercise1{
    public static void findNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input line to sum all numbers in it:");
        String line = scanner.nextLine();
        int sum = 0;
        for(int i = 0; i < line.length() ; i++){
            if(Character.isDigit(line.charAt(i))){
                sum = sum + Character.getNumericValue(line.charAt(i));
            }
        }
        System.out.println(sum);
    }
}
