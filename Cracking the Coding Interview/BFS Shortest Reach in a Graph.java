import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = 0;
            try {
                startId = scanner.nextInt() - 1;
            }
            catch(Exception e) {
                startId = 0;
            }
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}

class Graph {
    List<List<Integer>> adjList;
    
    public Graph(int size) {
        adjList = new ArrayList<List<Integer>>();
        for(int i = 0; i < size; i++) {
            List<Integer> list = new ArrayList<Integer>();
            adjList.add(list);
        }
    }

    public void addEdge(int first, int second) {
        this.adjList.get(first).add(second);
        this.adjList.get(second).add(first);
    }

    public int[] shortestReach(int startId) { // 0 indexed
        int[] results = new int[this.adjList.size()];
        boolean[] flags = new boolean[this.adjList.size()];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(startId);
        flags[startId] = true;
        while(!q.isEmpty()) {
            int curr = q.remove();
            for(int i = 0; i < this.adjList.get(curr).size(); i++) {
                int child = this.adjList.get(curr).get(i);
                if(!flags[child]) {
                    flags[child] = true;
                    q.add(child);
                    results[child] = results[curr] + 1;
                }
            }
        }
        for(int i = 0; i < this.adjList.size(); i++) {
            if(results[i] == 0)
                results[i] = -1;
            else if(i == startId)
                results[i] = 0;
            else
                results[i] *= 6;
        }
        return results;
    }
}