package ua.com.alevel.exercise1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CorrectFormatDate {
    static String inputFileName = "module_2/src/main/java/ua/com/alevel/exercise1/input.txt";
    static String outputFileName = "module_2/src/main/java/ua/com/alevel/exercise1/output.txt";

    final static String DATE_FORMAT1 = "yyyy/MM/dd";
    final static String DATE_FORMAT2 = "dd/MM/yyyy";
    final static String DATE_FORMAT3 = "MM-dd-yyyy";


    public static void readFile() throws IOException {
        Path inputPath = Paths.get(inputFileName);
        Scanner scanner = new Scanner(inputPath);
        Writer wr = new FileWriter(outputFileName);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            char[] array = line.toCharArray();
            for (int i=0; i<array.length-9; i++){
                int count = 0;
                if(!(Character.isDigit(array[i])))continue;
                String tempLine = "";
                boolean badFormat = true;
                for (int j=i; j<10+i; j++){
                    tempLine += String.valueOf(array[j]);
                    if(!(Character.isDigit(array[j]) || array[j] == '/' || array[j] == '-')){
                        badFormat = false;
                        break;
                    }
                }
                if(badFormat && checkFirstFormat(tempLine) && tempLine.charAt(4) == '/' && tempLine.charAt(7) == '/'){
                    for (int j=0; j<tempLine.length();j++){
                        if(Character.isDigit(tempLine.charAt(j))) count++;
                    }
                    if(count != 8) continue;
                    for (int j=0; j<tempLine.length();j++){
                        if(Character.isDigit(tempLine.charAt(j))) wr.write(tempLine.charAt(j));
                    }
                    wr.write(" ");
                }
                else if(badFormat && checkSecondFormat(tempLine) && tempLine.charAt(2) == '/'
                        && tempLine.charAt(5) == '/'){
                    for (int j=0; j<tempLine.length();j++){
                        if(Character.isDigit(tempLine.charAt(j))) count++;
                    }
                    if(count != 8) continue;
                    for (int j=0; j<tempLine.length();j++){
                        if(Character.isDigit(tempLine.charAt(j))) wr.write(tempLine.charAt(j));
                    }
                    wr.write(" ");
                }
                else if(badFormat && checkThirdFormat(tempLine) && tempLine.charAt(2) == '-'
                        && tempLine.charAt(5) == '-'){
                    for (int j=0; j<tempLine.length();j++){
                        if(Character.isDigit(tempLine.charAt(j))) count++;
                    }
                    if(count != 8) continue;
                    for (int j=0; j<tempLine.length();j++){
                        if(Character.isDigit(tempLine.charAt(j))) wr.write(tempLine.charAt(j));
                    }
                    wr.write(" ");
                }
            }
        }
        wr.flush();
        wr.close();
    }


    public static boolean checkFirstFormat(String date)
    {
        try {
            DateFormat format1 = new SimpleDateFormat(DATE_FORMAT1);
            format1.setLenient(false);
            format1.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean checkSecondFormat(String date)
    {
        try {
            DateFormat format2 = new SimpleDateFormat(DATE_FORMAT2);
            format2.setLenient(false);
            format2.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean checkThirdFormat(String date)
    {
        try {
            DateFormat format3 = new SimpleDateFormat(DATE_FORMAT3);
            format3.setLenient(false);
            format3.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}