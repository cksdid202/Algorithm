
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = N - 1;
		int min = Integer.MAX_VALUE;
		int result;
		int a = 0, b = 0;
		while(start < end) {
			result = arr[start] + arr[end];
			if(Math.abs(result) < min) {
				min = Math.abs(result);
				a = arr[start];
				b = arr[end];
			}
			if(result > 0) {
				end--;
			}
			else {
				start++;
			}
		}
		
		System.out.println(a + " " + b);
		
		
		

	}

}
