
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
			cnt=0;
			char[] line = br.readLine().toCharArray();
			if(line[0]=='1') cnt++;
			
			for(int i=0; i<line.length-1; i++) {
				if(line[i] != line[i+1]) {
					cnt++;
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(cnt).append("\n");
			
			
		}
		System.out.println(sb);

	}

}
