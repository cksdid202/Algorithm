
import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		
		int cnt;
		for(int t = 0; t < T; t++) {
			String line = br.readLine();
			char[] ch = line.toCharArray();
			if(ch[0]=='1') {
				cnt = 1;
			}
			else {
				cnt = 0;
			}
			for(int i=0; i<line.length()-1; i++) {
				if(ch[i]!=ch[i+1]) {
					cnt++;
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(cnt).append("\n");
		}
		
		
		
		
		
		
		
		
		
		
		
		System.out.println(sb);
		
		
		
	
		
	}

}
