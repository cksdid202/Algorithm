
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		
		while(true) {
			
			if(sum >= M) {
				sum -= arr[start++];
			}
			else if (end == N) {
				break;
			}
			else {
				sum += arr[end++];
			}
			
			if(sum == M) {
				cnt++;
			}
			
			
			
		}
		
		System.out.println(cnt);

	}

}
