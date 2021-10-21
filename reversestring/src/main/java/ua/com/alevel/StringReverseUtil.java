package ua.com.alevel;

import java.util.Scanner;
import java.io.*;

public class StringReverseUtil {


    public static String full_reverse(String text) {
        char[] temparray = text.toCharArray();
        int left, right = 0;
        right = temparray.length - 1;

        for (left = 0; left < right; left++, right--) {
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }

        text = String.valueOf(temparray);
        return text;
    }


    public static String substring_reverse(String text, String part){
        String reversedPart = "";
        for(int i = part.length() - 1; i >= 0; i--)
            reversedPart += part.charAt(i);
        String result = text.replaceAll(part, reversedPart);
        return result;
    }


    public  static String index_reverse(String text, int firstIndex, int lastIndex){
        String reversedPart = "";
        String part = text.substring(firstIndex,lastIndex);
        for(int i = part.length() - 1; i >= 0; i--)
            reversedPart += part.charAt(i);
        String result = text.replaceAll(part, reversedPart);
        return result;
    }
}
