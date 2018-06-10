import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static double median(int[] a, int i) {
        if(i == 1)
            return (double)a[0];
        if(i == 2)
            return (a[0] + a[1]) / 2.0f;
        Arrays.sort(a, 0, i);
        if(i % 2 == 1) {
            return (double)a[i / 2];
        }
        return (a[i / 2] + a[i / 2 - 1]) / 2.0f;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
            System.out.printf("%.1f\n", median(a, i+1));
        }

        scanner.close();
    }
}
