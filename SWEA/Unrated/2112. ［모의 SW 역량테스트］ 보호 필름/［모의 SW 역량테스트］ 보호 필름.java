
import java.util.*;
import java.io.*;

public class Solution {
	
	static int map [][];
	static int drug[];
	static int D, W, K;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			drug = new int[D];
			
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = K;
			dfs(0, 0);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		}
		
		System.out.print(sb);
		
		
	}
	
	public static void dfs(int idx, int count) {
		
		if(count >= result) return;
		
		if(idx == D) {
			if(isPass()) {
				result = Math.min(count, result);
			}
			return;
			
		}
		
		drug[idx] = -1;
		dfs(idx+1, count);
		
		drug[idx] = 0;
		dfs(idx+1, count+1);
		
		drug[idx] = 1;
		dfs(idx+1, count+1);
		
		drug[idx] = -1;
		
		
	}
	
	public static boolean isPass() {
		
		for(int c = 0; c < W; c++) {
			boolean colPass = false;
			int count = 1;
			
			for(int r = 1; r < D; r++) {
				int curr = (drug[r] != -1) ? drug[r] : map[r][c];
				int prev = (drug[r-1] != -1) ? drug[r-1] : map[r-1][c];
				
				if(curr == prev) {
					count++;
				} else {
					count = 1;
				}
				
				if(count == K) {
					colPass = true;
					break;
				}
				
			}
			if(!colPass) {
				return false;
			}
		}
		return true;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
