import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, C;
    static int[][] map;
    static int maxProfit; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); 
            M = Integer.parseInt(st.nextToken()); 
            C = Integer.parseInt(st.nextToken()); 

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            maxProfit = 0;
            
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) { 
                    
                    int profitA = getMaxProfit(i, j);

                    
                    for (int c = j + M; c <= N - M; c++) {
                        int profitB = getMaxProfit(i, c);
                        maxProfit = Math.max(maxProfit, profitA + profitB);
                    }

                    for (int r = i + 1; r < N; r++) {
                        for (int c = 0; c <= N - M; c++) {
                            int profitB = getMaxProfit(r, c);
                            maxProfit = Math.max(maxProfit, profitA + profitB);
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(maxProfit).append("\n");
        }
        System.out.println(sb);
    }     
    private static int getMaxProfit(int r, int c) {
        int[] honeys = new int[M];
        for (int i = 0; i < M; i++) {
            honeys[i] = map[r][c + i];
        }
        
        return subset(honeys, 0, 0, 0);
    }

    
    private static int subset(int[] honeys, int idx, int sum, int profit) {
        if (sum > C) return 0;
        
        if (idx == M) {
            return profit;
        }

        int take = subset(honeys, idx + 1, sum + honeys[idx], profit + (honeys[idx] * honeys[idx]));
        
        int skip = subset(honeys, idx + 1, sum, profit);

        return Math.max(take, skip);
    }
}