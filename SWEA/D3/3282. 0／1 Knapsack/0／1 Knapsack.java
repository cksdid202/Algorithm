import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken()); 

            int[] dp = new int[K + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken()); 
                int C = Integer.parseInt(st.nextToken()); 

                for (int j = K; j >= V; j--) {
                    if (dp[j] < dp[j - V] + C) {
                        dp[j] = dp[j - V] + C;
                    }
                }
            }

            System.out.println("#" + t + " " + dp[K]);
        }
    }
}