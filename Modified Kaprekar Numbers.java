import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        boolean found = false;
        for(int i = p; i <= q; i++) {
            long[] result = split(i);
            if(result[0] + result[1] == i) {
                found = true;
                System.out.print(i + " ");
            }
        }
        if(!found) {
            System.out.println("INVALID RANGE");
        }
    }
    
    static long[] split(int number) {
        long[] result = new long[2];
        long sq = (long)number * (long)number;
        int numDigits = (int)(Math.log10(number) + 1);
        int sqDigits = (int)(Math.log10(sq) + 1);
        result[1] = sq % (long)Math.pow(10, numDigits);
        if(sqDigits == 1) {
            result[0] = 0;
        }
        else {
            result[0] = sq / (long)Math.pow(10, numDigits);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
