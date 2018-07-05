import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String solve(int[] a){
        if(a.length == 1)
            return "YES";
        int sumAll = 0;
        for(int i = 0; i < a.length; i++) {
            sumAll += a[i];
        }
        int leftSum = a[0];
        for(int i = 1; i < a.length - 1; i++) {
            int rightSum = sumAll - leftSum - a[i];
            if(rightSum == leftSum) {
                return "YES";
            }
            leftSum += a[i];
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}