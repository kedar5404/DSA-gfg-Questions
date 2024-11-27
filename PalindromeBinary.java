//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class PalindromeBinary {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Long t = Long.parseLong(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isPallindrome(N));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static long isPallindrome(long N) {
        String binary = Long.toBinaryString(N);
        int left = 0, right = binary.length() - 1;
        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }
}
