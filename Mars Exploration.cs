using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {

    static int marsExploration(string s) {
        int count = 0;
        for(int i = 0; i < s.Length; i+=3) {
            if(s[i] != 'S') count++;
            if(s[i+1] != 'O') count++;
            if(s[i+2] != 'S') count++;
        }
        return count;
    }

    static void Main(String[] args) {
        string s = Console.ReadLine();
        int result = marsExploration(s);
        Console.WriteLine(result);
    }
}
