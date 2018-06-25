import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length -1);
    }
    
    static long mergeSort(int[] arr, int[] temp, int left, int right) {
        if(left >= right)
            return 0;
        long count = 0;
        int mid = (left + right) / 2;
        count += mergeSort(arr, temp, left, mid);
        count += mergeSort(arr, temp, mid + 1, right);
        count += merge(arr, temp, left, right);
        return count;
    }
    
    static long merge(int[] arr, int[] temp, int left, int right) {
        int mid = (left + right) / 2;
        int leftPointer = left;
        int rightPointer = mid + 1;
        int currPointer = left;
        long count = 0;
        
        while(leftPointer <= mid && rightPointer <= right) {
            if(arr[leftPointer] <= arr[rightPointer]) {
                temp[currPointer] = arr[leftPointer];
                leftPointer++;
            }
            else {
                temp[currPointer] = arr[rightPointer];
                rightPointer++;
                count += mid - leftPointer + 1;
            }
            currPointer++;
        }
        while(leftPointer <= mid) {
            temp[currPointer] = arr[leftPointer];
            currPointer++;
            leftPointer++;
        }
        while(rightPointer <= right) {
            temp[currPointer] = arr[rightPointer];
            currPointer++;
            rightPointer++;
        }
        
        for(int i = left; i < currPointer; i++) {
            arr[i] = temp[i];
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];
            
            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
