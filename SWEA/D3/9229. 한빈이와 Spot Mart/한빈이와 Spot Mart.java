
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		
		for(int t = 0; t < TC; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int start = 0;
			int end = N-1;
			int cnt = 0;
			int max = -1;
			
			while(start < end) {
				
				cnt = arr[start] + arr[end];
				
				if(cnt < M) {
					start++;
					if(cnt > max) {
						max = cnt;
					}
				}
				else if(cnt > M) {
					end--;
				}
				else {
					max = cnt;
					break;
				}
				
			}
			
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
			
			
			
			
		}
		System.out.println(sb);
		
		
		
	}

}
