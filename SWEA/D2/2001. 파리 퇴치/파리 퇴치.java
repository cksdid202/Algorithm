import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        for(int t = 0; t < T; t++) {
        	
        	st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	int[][] map = new int[N+1][N+1];
        	
        	for(int i = 1; i <= N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 1; j <= N; j++) {
        			int value = Integer.parseInt(st.nextToken());
        			map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + value;
        		}
        	}
        	
        	int max = 0;
        	for(int i = M; i <= N; i++) {
        		for(int j = M; j<= N; j++) {
        			int result = map[i][j] - map[i-M][j] - map[i][j-M] + map[i-M][j-M];
        			if(result > max) {
        				max =result;
        			}
        		}
        	}
        	
        	sb.append("#").append(t+1).append(" ").append(max).append("\n");
        	
        	
        }
        System.out.print(sb);
        
    }
}
