import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replaceAll("\\s", "");
        int len = s.length();
        double rootOfLen = Math.sqrt(len);
        int row = (int)Math.floor(rootOfLen);
        int col = (int)Math.ceil(rootOfLen);
        String encoded = "";
        for(int i = 0; i < col; i++) {
            for(int j = 0; j < col; j++) {
                int idx = (j * col) + i;
                if(idx < len) {
                    encoded += s.charAt(idx);
                }
            }
            encoded += " ";
        }
        return encoded.trim();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
