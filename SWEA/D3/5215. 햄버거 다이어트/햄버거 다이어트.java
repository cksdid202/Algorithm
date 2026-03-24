
import java.util.*;
import java.io.*;

public class Solution {
	
	static int N;
	static int L;
	static int[][] arr;
	static int[] numbers;
	static int maxKcal;
	static int maxPoint;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2];
			numbers = new int[N];
			
			for(int i = 0; i < N; i++) {
				
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				
			}
			maxKcal = Integer.MIN_VALUE;
			maxPoint = Integer.MIN_VALUE;
			johab(0, 0, 0, 0);
			//subset(0, 0, 0, 0);
			sb.append('#').append(t).append(" ").append(maxPoint).append("\n");
			
			
			
		}
		
		System.out.print(sb);
		
	}
	
	public static void johab(int start, int kcal, int cnt, int point) {
		
		if(kcal > L) {
			return;
		}
		if(kcal > maxKcal) {
			maxKcal = kcal;
		}
		if(point > maxPoint) {
			maxPoint = point;
		}
		
		for(int i = start; i < N; i++) {
			johab(i+1, arr[i][1]+kcal, cnt+1, arr[i][0]+point);
		}
		
	}
	
	public static void subset(int start, int kcal, int point, int cnt) {
		
		
		if(kcal > L) {
			return;
		}
		if(kcal > maxKcal) {
			maxKcal = kcal;
		}
		if(point > maxPoint) {
			maxPoint = point;
		}
		if(start == N) {
			return;
		}
		
		
		subset(start+1, kcal, point, cnt);
		
		subset(start+1, arr[start][1] + kcal, arr[start][0] + point, cnt+1);
		
	}
	
	
	
	

}

/*
 * 1
5 1000
100 200
300 500
250 300
500 1000
400 400
 */
