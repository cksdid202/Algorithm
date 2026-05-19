
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			
			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] buildings = new int [N];
			for(int i = 0; i < N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxLeft = 0;
			int maxRight = 0;
			int max = 0;
			int sum = 0;
			for(int i = 2; i < N-2; i++) {
				
				maxLeft = Math.max(buildings[i-1], buildings[i-2]);
				maxRight = Math.max(buildings[i+1], buildings[i+2]);
				max = Math.max(maxLeft, maxRight);
				
				if(buildings[i] > max) {
					sum += buildings[i] - max;
				}
			}
			
			sb.append('#').append(t).append(' ').append(sum).append('\n');
			
			
		}
		System.out.print(sb);
	}

}
