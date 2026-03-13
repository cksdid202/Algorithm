
import java.util.*;
import java.io.*;

public class Solution {
	
	public static int[][] jaeryo;
	public static int N;
	public static int L;
	public static int maxPoint;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			jaeryo = new int [N][2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				jaeryo[i][0] = Integer.parseInt(st.nextToken());
				jaeryo[i][1] = Integer.parseInt(st.nextToken());
			}
			maxPoint = 0;
			johap(0, 0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(maxPoint).append("\n");
			
			
		}
		System.out.print(sb);
		
		
		
	}
	
	public static void johap(int cnt, int start, int point, int kcal) {
		
		if (maxPoint < point) {
			maxPoint = point;
		}
		
		for(int i = start; i < N; i++) {
			
			if(jaeryo[i][1] + kcal <= L ) {
				
				johap(cnt+1, i+1, point+jaeryo[i][0], kcal+jaeryo[i][1]);
				
			}
			
		}
		
		
	}
	
	
	
	
	
	

}
