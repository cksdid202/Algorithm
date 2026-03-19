
import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] pyo;
	static int maxBenefit = Integer.MIN_VALUE;
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		pyo = new int[N+1][2];
		
		for(int i = 1; i <= N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			pyo[i][0] = Integer.parseInt(st.nextToken());
			pyo[i][1] = Integer.parseInt(st.nextToken());
			
			
		}
		
		subset(1, 0, 0);
		
		System.out.print(maxBenefit);
		
		
		
	}
	
	public static void subset(int diff, int pay, int cnt) {
	    
	    if(diff > N + 1) {
	        return;
	    }
	    
	    if(maxBenefit < pay) {
	        maxBenefit = pay;
	    }
	    
	    if(diff == N + 1) {
	        return;
	    }
	    
	    subset(diff + pyo[diff][0], pay + pyo[diff][1], cnt + 1);
	    subset(diff + 1, pay, cnt);
	}
	
	

}
