import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	//static int cnt = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger count = new BigInteger("2");
		System.out.println(count.pow(N).subtract(BigInteger.ONE));
		
		if(N<=20) {
			hanoi(N, 1, 3, 2);
			//System.out.println(cnt);
			System.out.println(sb);
		}
		
		
		

	}
	
	public static void hanoi(int n, int start, int to, int mid) {
		
		//종료
		if(n == 1) {
			sb.append(start).append(" ").append(to).append("\n");
			//cnt++;
			return;
		}
		hanoi(n - 1, start, mid, to);
		
		sb.append(start).append(" ").append(to).append("\n");
		//cnt++;
		
		hanoi(n - 1, mid, to, start);
		
		
	}

}