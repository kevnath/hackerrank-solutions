import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for(String s : magazine) {
            if(!dictionary.containsKey(s)) {
                dictionary.put(s, 1);
            }
            else {
                dictionary.put(s, dictionary.get(s) + 1);
            }
        }
        boolean isValid = true;
        for(String s : note) {
            if(!dictionary.containsKey(s)) {
                isValid = false;
                break;
            }
            else {
                int wordCount = dictionary.get(s);
                if(--wordCount == 0) {
                    dictionary.remove(s);
                }
                else {
                    dictionary.put(s, wordCount);
                }
            }
        }
        System.out.println(isValid ? "Yes" : "No");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
