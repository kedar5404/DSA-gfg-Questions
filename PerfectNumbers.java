import java.io.*;
import java.util.*;

class PerfectNumbers {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine()); // Read the number of test cases
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine()); // Parse input as an integer

            Solution ob = new Solution();
            int ans = ob.isPerfectNumber(N);
            if (ans == 1)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int isPerfectNumber(long N) {
        long sum = 0;
        for (int i = 1; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                sum = sum + i;
                if (N / i != N)// The condition ensures that N itself is not
                    // added to the sum of divisors.
                    sum = sum + N / i;
            }
        }
        if (sum == N) {
            return 1;
        }
        return 0;
    }
}
