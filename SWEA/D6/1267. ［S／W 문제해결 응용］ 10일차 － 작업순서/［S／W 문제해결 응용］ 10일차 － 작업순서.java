
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for(int t = 1; t <= 10; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<Integer>[] adj = new ArrayList[V+1];
			for(int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}
			int[] inDegrees = new int [V+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= E; i++) {
				
				int pre = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				
				adj[pre].add(next);
				inDegrees[next]++;
				
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			
			for(int i = 1; i <= V; i++) {
				if(inDegrees[i] == 0) {
					q.offer(i);
				}
			}
			
			sb.append('#').append(t);
			while(!q.isEmpty()) {
				
				int size = q.size();
				
				for(int i = 0; i < size; i++) {
					
					int curr = q.poll();
					sb.append(' ').append(curr);
					
					for(int next : adj[curr]) {
						inDegrees[next]--;
						if(inDegrees[next]==0) {
							q.offer(next);
						}
					}
					
				}
			}
			sb.append('\n');
			
			
		}
		System.out.print(sb);
		
			
	}

}
