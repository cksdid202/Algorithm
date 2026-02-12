
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				for(int j = 0; j < N; j++) {
					arr[i][j] = line.charAt(j) - '0';
				}
			}
			
			int cnt = 0;
						int start = N / 2;
						int end = N / 2;
						
						for(int i = 0; i < N; i++) {
							
							for(int j = start; j <= end; j++) {
								cnt += arr[i][j];
							}
							// 중간부터는 줄이기 : 다이아몬드
							if (i < N / 2) {
								start--; 
								end++;   
							} else {
								start++; 
								end--;   
							}
						}
						
						sb.append("#").append(t + 1).append(" ").append(cnt).append("\n");
			
		}
		
		System.out.println(sb);
		
		
	}

}
