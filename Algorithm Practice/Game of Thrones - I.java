import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        boolean evenFound = false;
        int oddCount = 0;
        for(Character key : map.keySet()) {
            int count = map.get(key);
            if(count % 2 == 1) {
                oddCount++;
            }
            else {
                evenFound = true;
            }
        }
        return (evenFound && oddCount <= 1) ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
