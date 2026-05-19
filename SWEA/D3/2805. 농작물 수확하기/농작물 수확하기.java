
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int t = 1; t <= T; t++) {
    		
    		int N = Integer.parseInt(br.readLine());
    		
    		int[][] prefixSum = new int[N+1][N+1];
    		
    		for(int i = 1; i <= N; i++) {
    			String line = br.readLine();
    			for(int j = 1; j <= N; j++) {
    				int value = line.charAt(j - 1) - '0';
    				
    				prefixSum[i][j] = prefixSum[i][j-1] + value;
    			}
    		}
    		
    		int totalHarvest = 0;
    		int mid = N / 2 + 1;
    		int range = 0;
    		
    		for (int i = 1; i <= N; i++) {
    			
    			
    			int start = mid - range;
    			int end = mid + range;
    			
    			totalHarvest += (prefixSum[i][end] - prefixSum[i][start - 1]);
    			
    			if (i < mid) {
    				range++;
    			}
    			else {
    				range--;
    			}
    			
    			
    			
    		}
    		
    		sb.append('#').append(t).append(' ').append(totalHarvest).append('\n');
    		
    		
    		
    		
    		
    		
    	}
    	System.out.print(sb);
        
    	
    }
}
