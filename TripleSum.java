
import java.io.*;
import java.util.*;

class TripleSum {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" "); // Split the input string by spaces
            int[] nums = new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            boolean ans = ob.hasTripletSum(nums, target); // Call the function and store result
            System.out.println(ans ? "true" : "false"); // Output the result
        }
    }
}

class Solution {
    // Should return true if there is a triplet with sum equal
    // to x in arr[], otherwise false
    public static boolean hasTripletSum(int arr[], int target) {
        int n = arr.length;
        // Sort the array
        Arrays.sort(arr);

        // Traverse each element in the array
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1; // Left pointer
            int r = n - 1; // Right pointer

            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == target) {
                    return true; // Triplet found
                } else if (sum < target) {
                    l++; // Move left pointer to the right
                } else {
                    r--; // Move right pointer to the left
                }
            }
        }
        return false; // No triplet found
    }
}
