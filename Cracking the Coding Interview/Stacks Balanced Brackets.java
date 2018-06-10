import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static boolean check(String str) {
        if(str.length() < 2)
            return false;
        
        Stack<Character> stack = new Stack<Character>();
        for(char c : str.toCharArray()) {
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else if(c == '}' || c == ']' || c == ')') {
                if(stack.isEmpty())
                    return false;
                char p = stack.pop();
                if(c == '}' && p != '{')
                    return false;
                if(c == ']' && p != '[')
                    return false;
                if(c == ')' && p != '(')
                    return false;
            }
        }
        if(stack.size() > 0)
            return false;
        return true;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            boolean result = check(expression);
            System.out.println(result ? "YES" : "NO");
        }

        scanner.close();
    }
}
