
import java.util.*;
import java.io.*;
import java.math.*;


public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			BigInteger A = new BigInteger(st.nextToken());
			BigInteger B = new BigInteger(st.nextToken());
			
			sb.append("#").append(i+1).append(" ").append(A.add(B)).append("\n");

		}
		
		System.out.println(sb);
		
		
		
	
		
	}

}
