import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        
        int[] frequency = new int[26];
        for(char c : a.toCharArray()) {
            frequency[c - 'a']++;
        }
        for(char c : b.toCharArray()) {
            frequency[c - 'a']--;
        }
        int result = 0;
        for(int f : frequency) {
            result += Math.abs(f);
        }
        System.out.println(result);
        scanner.close();
    }
}
