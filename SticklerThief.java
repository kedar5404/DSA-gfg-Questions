import java.io.*;
import java.util.*;

class SticklerThief {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr, n));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to find the maximum money the thief can get.
    public int findMaxSum(int arr[], int n) {
        // Edge cases
        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];

        // Initialize dp variables
        int prev1 = 0; // dp[i-2]
        int prev2 = arr[0]; // dp[i-1]

        for (int i = 1; i < n; i++) {
            int curr = Math.max(prev2, arr[i] + prev1);
            // Update for next iteration
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2; // This will be dp[n-1]
    }
}
