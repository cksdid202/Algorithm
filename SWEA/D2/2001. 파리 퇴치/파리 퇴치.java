
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[][] S = new int[N + 1][N + 1];
            
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    
                    S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + val;
                }
            }
            
            int max = 0;
            
            for(int i = M; i <= N; i++) {
                for(int j = M; j <= N; j++) {
                    
                    int sum = S[i][j] - S[i-M][j] - S[i][j-M] + S[i-M][j-M];
                    
                    if(max < sum) {
                        max = sum;
                    }
                }
            }
            
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        
        System.out.println(sb);
    }
}
