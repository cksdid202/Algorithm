import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {

	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] cards = new String[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cards[i] = st.nextToken(); // 공백 구분
			}
			
			sb.append("#").append(t);
			
			int mid = (N + 1) / 2;
			
			int p1 = 0;
			int p2 = mid;
			
			for (int i = 0; i < mid; i++) {
				sb.append(" ").append(cards[p1++]); 
				
				if(p2 < N) {
					sb.append(" ").append(cards[p2++]);
				}
			}
			sb.append("\n");
			
			
			
		}
		System.out.println(sb);
		
	}

}