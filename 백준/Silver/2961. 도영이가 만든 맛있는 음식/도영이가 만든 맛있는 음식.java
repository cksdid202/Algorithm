
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] jaeryo;
	static int mindiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		jaeryo = new int[N][2];
		
		for(int i = 0 ; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			jaeryo[i][0] = Integer.parseInt(st.nextToken());
			jaeryo[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		subset(0, 1, 0, 0);
		
		System.out.print(mindiff);
		
		
	}
	
	public static void subset (int depth, int sour, int bitter, int cnt) {
		
		if(depth == N) {
			if(cnt > 0) {
				if(mindiff > Math.abs(sour - bitter)) {
					mindiff = Math.abs(sour - bitter);
				}
			}
			return;
		}
		
		// 재료 선택
		subset(depth+1, jaeryo[depth][0]*sour, jaeryo[depth][1]+bitter, cnt+1);
		
		// 재료 미선택
		subset(depth+1, sour, bitter, cnt);
		
		
		
		
		
	}
	
	

}
