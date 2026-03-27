
import java.util.*;
import java.io.*;

public class Solution {
	
	static int N, M, C;
	static int[][] map, profitMap;
	static int maxProfit;
	static int result;
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			profitMap = new int[N][N-M+1];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = 0;
			makeProfitMap();
			
			selectTwo(0, 0, 0, 0);
			
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		}
		System.out.print(sb);

		
		
		
		
	}
	
	public static void makeProfitMap () {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - M + 1; j++) {
				maxProfit = 0;
				findMaxSubset(i, j, 0, 0, 0);
				profitMap[i][j] = maxProfit; 
			}
		}
		
		
	}
	
	public static void findMaxSubset(int r, int c, int cnt, int sum, int ggul) {
		
		if(ggul > C) {
			return;
		}
		
		if(sum > maxProfit) {
			maxProfit = sum;
		}
		
		if(cnt == M) {
			return;
		}
		
		
		findMaxSubset(r, c+1, cnt+1, sum + map[r][c]*map[r][c], ggul + map[r][c]);
		
		findMaxSubset(r, c+1, cnt+1, sum, ggul);
		
	}
	
	
	
	public static void selectTwo (int r, int c, int cnt, int sum) {
		
		if(cnt == 2) {
			if(result < sum) {
				result = sum;
			}
			return;
		}
		
		for(int i = r; i < N; i++) {
			
			int startJ = (i == r) ? c : 0;
			for(int j = startJ ; j < N - M + 1; j++) {
				
				if(j+M < N - M + 1) {
					selectTwo(i, j+M, cnt+1, sum+profitMap[i][j]);
				}
				else {
					selectTwo(i+1, 0, cnt+1, sum+profitMap[i][j]);
				}
				
				
			}
		}
		
	}
	
	
	
	
	
	
	
	

}
