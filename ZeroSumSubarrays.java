
//{ Driver Code Starts
import java.util.*;

public class ZeroSumSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases
        sc.nextLine(); // Consume the newline

        while (t-- > 0) {
            String input = sc.nextLine(); // Input array as a space-separated string
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];

            // Parse the input array
            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findSubarray(arr));
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends

class Solution {
    public int findSubarray(int[] arr) {
        Map<Long, Long> map = new HashMap<>();
        long sum = 0;
        long ans = 0;
        int n = arr.length;
        map.put(0L, 1L);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                ans += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1L);
            }
        }
        return (int) ans;
    }
}
