import java.util.*;
import java.lang.*;
import java.io.*;

class ArrangingTheArr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            obj.Rearrange(a, n);

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++)
                output.append(a[i] + " ");
            System.out.println(output);

            System.out.println("~");
        }
    }
}

class Solution {
    public void Rearrange(int a[], int n) {
        int j = 0;
        if (a[0] < 0) {
            j++;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] < 0) {
                if (j < i) {
                    int temp = a[i];
                    for (int k = i; k > j; k--) {
                        a[k] = a[k - 1];
                    }
                    a[j] = temp;
                    j++;
                } else {
                    j++;
                }
            }
        }
    }
}
