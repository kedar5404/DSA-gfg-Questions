
import java.io.*;
import java.util.*;

class LargestSquareFormedInMatrix {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(mat));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int maxSquare(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int ans = Integer.MIN_VALUE;
        int dp[][] = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 || j == m - 1 || mat[i][j] == 0)
                    dp[i][j] = mat[i][j]; // if value of last row or column is 1 then dp value
                // of dp is 1
                else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
