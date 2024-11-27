
/*
 * In a candy store, there are n different types of candies available and the prices of all the N 
 * different types of candies are provided to you. You are now provided with an attractive offer.
For every candy you buy from the store and get K other candies ( all are different types ) for free. 
Now you have to answer two questions. Firstly, you have to find what is the minimum amount of money 
you have to spend to buy all the n different candies. Secondly, you have to find what is the 
maximum amount of money you have to spend to buy all the n different candies.
In both the cases you must utilize the offer i.e. you buy one candy and get k other candies for 
free.

Examples :

Input: n = 4, k = 2, candies[] = {3 2 1 4}
Output: 3 7
Explanation: As according to the offer if you buy one candy you can take at most two  more for free. 
So in the first case, you buy the candy which costs 1 and takes candies worth 3 and 4 for free, 
also you buy candy worth 2 as well.So min cost : 1+2 =3. In the second case, you can buy the candy 
which costs 4 and takes candies worth 1 and 2 for free, also you need to buy candy worth 3 as well. 
So max cost : 3+4 =7.
 */
import java.io.*;
import java.util.*;

class ShopInCandyStore {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int candies[] = new int[N];
            for (int i = 0; i < N; i++)
                candies[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> cost = ob.candyStore(candies, N, K);
            System.out.println(cost.get(0) + " " + cost.get(1));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    static ArrayList<Integer> candyStore(int candies[], int N, int K) {
        Arrays.sort(candies);
        int min = 0;
        for (int i = 0, j = N - 1; i <= j; i++) {
            min = min + candies[i];
            j -= K;
        }
        int max = 0;
        for (int i = N - 1, j = 0; i >= j; i--) {
            max = max + candies[i];
            j += K;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(min);
        ans.add(max);
        return ans;
    }
}
