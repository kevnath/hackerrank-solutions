import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        Trie trie = new Trie();
        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];
            
            if(op.equals("add")) {
                trie.add(contact);
            }
            else {
                System.out.println(trie.findPartial(contact));
            }
        }

        scanner.close();
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    int size = 0;
    
    public boolean isChildrenExists(char c) {
        return this.children.containsKey(c);
    }
    
    public TrieNode getChild(char c) {
        if(!this.isChildrenExists(c))
            return null;
        return children.get(c);
    }
    
    public void addChild(char c) {
        if(!this.isChildrenExists(c)) {
            this.children.put(c, (new TrieNode()));
        }
    }
    
    public int getSize() {
        return this.size;
    }
    
    public void increaseSize() {
        this.size++;
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void add(String s) {
        TrieNode curr = root;
        for(char c : s.toCharArray()) {
            curr.addChild(c);
            curr = curr.getChild(c);
            curr.increaseSize();
        }
    }
    
    public int findPartial(String s) {
        TrieNode curr = root;
        for(char c : s.toCharArray()) {
            curr = curr.getChild(c);
            if(curr == null)
                return 0;
        }      
        return curr.getSize();
    }
}
