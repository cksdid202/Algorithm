
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			String line = br.readLine();
			
			int result = 1;
			
			for(int i = 0; i <= line.length() / 2; i++) {
				
				if(line.charAt(i) != line.charAt(line.length()-1-i)) {
					result = 0;
					break;
				}
				
			}
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
			
			
			
		}
		System.out.print(sb);
		
	}

}
