
import java.util.*;
import java.io.*;

public class Main {
	
	public static int k;
	public static int[] arr;
	public static int[] numbers;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		while(k != 0) {
			arr = new int[k];
			numbers = new int[k];
			for(int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			johab(0, 0);
			
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			System.out.println();
			
		}
		
		
		
		
		
	}
	
	
	public static void johab(int start, int cnt) {
		
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < k; i++) {
			numbers[cnt] = arr[i];
			johab(i + 1, cnt+1);
		}
	
		
	}
	

}
