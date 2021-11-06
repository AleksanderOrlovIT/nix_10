package ua.com.alevel.level2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class CorrectBrackets {
    public static void CorrectBracketsMain(){
        int restartTemp;
        do {
            int count = 0;
            String result;
            Scanner sc = new Scanner(System.in);
            System.out.println("Please input line with brackets");
            String text = sc.nextLine();
            HashMap<String, Integer> openBrackets = new HashMap<String, Integer>() {{
                put("{", 0);
                put("[", 1);
                put("(", 2);
            }};
            HashMap<String, Integer> closeBrackets = new HashMap<String, Integer>() {{
                put("}", 0);
                put("]", 1);
                put(")", 2);
            }};
            Stack<String> stack = new Stack<>();
            if(text.equals("")) result = "correct";
            else result = "incorrect";

            for (int i = 0; i < text.length(); i++) {
                Character character = text.charAt(i);
                String symbol = character.toString();

                if (openBrackets.containsKey(symbol)) {
                    stack.push(symbol);
                } else if (closeBrackets.containsKey(symbol)) {
                    if (stack.empty() || !openBrackets.get(stack.pop()).equals(closeBrackets.get(symbol))) {
                        result = "incorrect";
                        break;
                    } else result = "correct";
                }
            }
            for (int i = 0; i < text.length(); i++) {
                Character character = text.charAt(i);
                char temp = character;
                String symbol = character.toString();
                if (openBrackets.containsKey(symbol) || closeBrackets.containsKey(symbol)) {
                    stack.push(symbol);
                }
                if (temp == '(' || temp == ')' || temp == '[' || temp == ']' || temp == '{' || temp == '}') {
                    count++;
                }
                if (i == text.length() - 1) {
                    if (stack.empty()) ;
                    else if (!stack.peek().equals("]") && !stack.peek().equals(")") && !stack.peek().equals("}"))
                        result = "incorrect";
                }
            }
            if (count % 2 != 0) result = "incorrect";
            System.out.println(result);
            System.out.println("Please press 1 if you want to restart the CorrectBrackets application," +
                    " otherwise press any other number");
            while(!sc.hasNextInt()){
                sc.next();
            }
            restartTemp = sc.nextInt();
        }while (restartTemp == 1);
    }
}
