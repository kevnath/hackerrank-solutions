import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        int max = 0;
        boolean[][] flags = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int count = dfs(grid, i, j, flags);
                if(count > max) max = count;
            }
        }
        return max;
    }
    
    static int dfs(int[][] grid, int x, int y, boolean[][] flags) {
        int count = 0;
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return count;
        }
        if(flags[x][y])
            return count;
        if(grid[x][y] == 1) {
            flags[x][y] = true;
            count++;
        }
        count += dfs(grid, x, y - 1, flags);
        count += dfs(grid, x + 1, y - 1, flags);
        count += dfs(grid, x + 1, y, flags);
        count += dfs(grid, x + 1, y + 1, flags);
        count += dfs(grid, x, y + 1, flags);
        count += dfs(grid, x - 1, y + 1, flags);
        count += dfs(grid, x - 1, y, flags);
        count += dfs(grid, x - 1, y - 1, flags);
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
