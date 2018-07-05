import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                int count = dfs(matrix, i, j);
                max = Math.max(max, count);
            }
        }
        return max;
    }
    
    static int dfs(int[][] matrix, int x, int y) {
        if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[x].length) {
            return 0;
        }
        if(matrix[x][y] == 0) {
            return 0;
        }
        
        matrix[x][y] = 0;
        int size =  1;
        size += dfs(matrix, x, y - 1);
        size += dfs(matrix, x + 1, y - 1);
        size += dfs(matrix, x + 1, y);
        size += dfs(matrix, x + 1, y + 1);
        size += dfs(matrix, x, y + 1);
        size += dfs(matrix, x - 1, y + 1);
        size += dfs(matrix, x - 1, y);
        size += dfs(matrix, x - 1, y - 1);
        return size;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
