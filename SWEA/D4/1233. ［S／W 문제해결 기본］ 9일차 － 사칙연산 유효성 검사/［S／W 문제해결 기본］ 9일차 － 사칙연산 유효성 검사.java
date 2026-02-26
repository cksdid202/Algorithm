
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < 10; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int result = 1;
			
			for(int i=0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				st.nextToken();
				
				char ch = st.nextToken().charAt(0);
				
				if(st.hasMoreTokens()) {
					if(Character.isDigit(ch)) {
						result = 0;
					}
					
				}
				else {
					if(!(Character.isDigit(ch))) {
						result = 0;
					}
					
				}
				
				
				
			}
			
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
			
			
			
			
		}
		
		System.out.print(sb);
		
		
		
		
	}

}
