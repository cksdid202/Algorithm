
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int trees[] = new int [N];
			int maxH = 0;
			for(int i = 0; i < N; i++) {
				
				trees[i] = Integer.parseInt(st.nextToken());
				if(maxH < trees[i]) {
					maxH = trees[i];
				}
				
			}
			
			int even = 0;
			int odd = 0;
			
			for(int i = 0; i < N; i++) {
				int diff = maxH - trees[i];
				
				even += diff / 2;
				odd += diff % 2;
			}
			
			while(even > odd + 1) {
				even--;
				odd += 2;
			}
			
			int result = 0;
			if(even == odd) {
				result = even * 2;
			}
			else if(even < odd) {
				result = odd * 2 - 1;
			}
			else {
				result = even * 2;
			}
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
			
			
			
		}
		System.out.print(sb);
		

	}

}
