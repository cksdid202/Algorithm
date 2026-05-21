
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception  {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int t = 1; t <= T; t++) {
    		
    		int N = Integer.parseInt(br.readLine());
    		
    		int[][] arr = new int[N+1][N+1];
    		
    		int[][] presum = new int [N+1][N+1];
    		for(int i = 1; i <= N; i++) {
    			String line = br.readLine();
    			for(int j = 1; j <= N; j++) {
    				
    				arr[i][j] = (line.charAt(j-1) - '0');
    				presum[i][j] = presum[i][j-1] + arr[i][j];
    			}
    		}
    		
    		int mid = N / 2 + 1;
    		int result = 0;
    		int range = 0;
    		int left = mid;
    		int right = mid;
    		for(int i = 1; i <= N; i++) {
    			
    			right = mid + range;
    			left = mid - range;
    			int tmp = presum[i][right] - presum[i][left-1];
    			result += tmp;
    			if(i < mid) {
    				range++;
    			}
    			else {
    				range--;
    			}
    			
    		}
    		
    		sb.append('#').append(t).append(' ').append(result).append('\n');
    		
    		 
    		
    		
    		
    	}
        System.out.print(sb);
    	
    }
}
