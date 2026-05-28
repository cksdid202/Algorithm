
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			String line = br.readLine();
			
			int len = line.length();
			String reverse = "";
			
			for(int i = len-1; i >= 0; i--) {
				reverse += line.charAt(i);
			}
			
			int result = 0;
			if(line.equals(reverse)) {
				result = 1;
			}
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
			
		}
		System.out.print(sb);
		
	}

}
