import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static boolean isPrime(int num) {
        if(num <= 1)
            return false;
        int div = 2;
        while(((long)div * (long)div) <= num) {
            if(num % div == 0)
                return false;
            div++;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            boolean result = isPrime(n);
            System.out.println(result ? "Prime" : "Not prime");
        }
        scanner.close();
    }
}
