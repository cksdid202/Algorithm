
import java.util.*;
import java.io.*;
import java.math.*;


class Top {
	int num;
	int height;
	
	public Top(int num, int height) {
		this.num = num;
		this.height = height;
	}
}


public class Main {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Top> stack = new Stack<>();
		
		for(int i=1; i<=N; i++) {
			int currentHeight = Integer.parseInt(st.nextToken());
			
			while(true) {
				
				if(stack.isEmpty()) {
					sb.append("0 ");
					stack.push(new Top(i, currentHeight));
					break;
				}
				
				Top top = stack.peek();
				
				if(top.height >= currentHeight) {
					sb.append(top.num).append(" ");
					stack.push(new Top(i, currentHeight));
					break;
				}
				else {
					stack.pop();
				}
				
			}
			
			
		}
		
		System.out.println(sb);
		
		
		
		
		
	}

}
