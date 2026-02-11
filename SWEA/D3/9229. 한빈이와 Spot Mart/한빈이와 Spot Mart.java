
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] weights = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(weights);
			
			int left = 0;
			int right = N -1;
			int maxResult = -1;
			
			while (left < right) {
				int sum = weights[left] + weights[right];
				
				if(sum > M) {
					right--;
				}
				else {
					if(maxResult < sum) {
						maxResult = sum;
					}
					left++;
				}
			}
			sb.append("#").append(t).append(" ").append(maxResult).append("\n");
			
		}
		System.out.print(sb);
		
		
		
	}

}
