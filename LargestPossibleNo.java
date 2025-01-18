
import java.io.*;
import java.util.*;

class LargestPossibleNo {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            int S = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));

            System.out.println("~");
        }
    }
}

class Solution {
    static String findLargest(int N, int S) {
        if (N * 9 < S)
            return "-1";
        if (N > 1 && S == 0)
            return "-1";
        if (S == 0)
            return "0";
        String res = "";
        int maxDigit = 9;
        while (maxDigit > 0 && res.length() < N) {
            int maxFreq = S / maxDigit;
            S -= maxDigit * maxFreq;
            res += Integer.toString(maxDigit).repeat(maxFreq);
            maxDigit--;
        }
        if (res.length() < N)
            res += "0".repeat(N - res.length());
        return res;
    }
}
