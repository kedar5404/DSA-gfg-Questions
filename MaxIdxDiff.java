
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class MaxIdxDiff {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxIndexDiff(arr));
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to find the maximum index difference.
    int maxIndexDiff(int[] arr) {
        int n = arr.length;
        int min[] = new int[n];
        int max[] = new int[n];
        min[0] = arr[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], arr[i]);
        }
        max[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], arr[i]);
        }
        int i = 0, j = 0, count = 0;
        while (i < n && j < n) {
            if (min[i] <= max[j]) {
                count = Math.max(count, j - i);
                j++;
            } else {
                i++;
            }
        }
        return count;
    }
}
