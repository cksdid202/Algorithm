
import java.util.*;
import java.io.*;

public class Solution {
	
	static int N;
	static int M;
	static int[][] arr;
	static int[] numbers;
	static int count;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[M][2];
			numbers = new int[N];
			
			for(int i = 0; i < M; i++) {
				
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				
			}
			count = 0;
			johab(1, 0);
			sb.append('#').append(t).append(" ").append(count).append("\n");
			
			
			
		}
		
		System.out.print(sb);
		
	}
	
	public static void johab(int start, int cnt) {
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < cnt; j++) {
				if(arr[i][0] == numbers[j]) {
					for(int k = 0; k < cnt; k++) {
						if(arr[i][1] == numbers[k]) {
							return;
						}
					}
				}
			}
		}
		count++;
		
		for(int i = start; i <= N; i++) {
			numbers[cnt] = i;
			johab(i+1, cnt+1);
		}
		
	}
	
	
	
	
	
	

}
