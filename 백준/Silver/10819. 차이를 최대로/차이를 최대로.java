
import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr;
	static int[] numbers;
	static boolean[] visited;
	static int maxCnt = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		numbers = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		soonyeol(0);
		
		System.out.print(maxCnt);
		
	}
	
	public static void soonyeol(int depth) {
		
		if(depth == N) {
			int sum = 0;
			
			for(int j = 0; j < N-1; j++) {
				sum += Math.abs(numbers[j] - numbers[j+1]); 
			}
			maxCnt = Math.max(sum, maxCnt);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			
			if(!visited[i]) {
				visited[i] = true;
				
				numbers[depth] = arr[i];
				
				soonyeol(depth + 1);
				
				visited[i] = false;
				
			}
			
		}
		
		
	}
	
	
	
	

}
