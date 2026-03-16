
import java.util.*;
import java.io.*;

public class Main{
	
	public static int[] dol;
	public static boolean[] isSelected;
	public static int N, S;
	public static int result = 0;
	
	public static void main(String[] args) throws Exception {
		//------여기에 솔루션 코드를 작성하세요.------------
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		dol = new int[N];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			dol[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0, 0, 0);
		
		System.out.print(result);
		
		
		
	}
	
	public static void combination(int cnt, int number, int start) {
		
		if(cnt == S && number != 0) {
			result++;
		}
		
		for(int i = start; i < N; i++) {
			combination(cnt+dol[i], number+1, i+1);
		}
		
		
		
	}
	

	
	
	
}