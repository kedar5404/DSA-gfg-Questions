import java.io.*;
import java.util.*;

public class PythagoreanTriplet {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().pythagoreanTriplet(arr);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i] * arr[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sumOfSqures = arr[i] * arr[i] + arr[j] * arr[j];
                if (set.contains(sumOfSqures))
                    return true;
            }
        }
        return false;
    }
}
