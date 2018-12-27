import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class Customer {
        public int no;
        public int orderNo;
        public int prepTime;
        public int deliveredTime;
        
        public Customer(int no, int orderNo, int prepTime) {
            this.no = no;
            this.orderNo = orderNo;
            this.prepTime = prepTime;
            this.deliveredTime = orderNo + prepTime;
        }
    }
    
    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        List<Customer> customers = new ArrayList<>();
        for(int i = 1; i <= orders.length; i++) {
            Customer customer = new Customer(i, orders[i-1][0], orders[i-1][1]);
            customers.add(customer);
        }
        Collections.sort(customers, new Comparator<Customer>() {
            public int compare(Customer c1, Customer c2) {
                if(c1.deliveredTime == c2.deliveredTime)
                    return Integer.compare(c1.no, c2.no);
                return Integer.compare(c1.deliveredTime, c2.deliveredTime);
            }
        });
        int[] result = new int[orders.length];
        for(int i = 0; i < customers.size(); i++) {
            result[i] = customers.get(i).no;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
