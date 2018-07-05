import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(String s : arr) {
            Set<Character> set = new LinkedHashSet();
            for(char c : s.toCharArray()) {
                if(!set.contains(c)) {
                    set.add(c);
                    map.putIfAbsent(c, 0);
                    map.put(c, map.get(c)+1);
                }
            }
        }
        int res = 0;
        for(Character c : map.keySet()) {
            int num = map.get(c);
            if(num == arr.length) {
                res++;
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
