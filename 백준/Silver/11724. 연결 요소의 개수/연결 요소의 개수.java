
import java.util.*;
import java.io.*;

public class Main {

	static boolean[][] edge;
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		edge = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int e1 = Integer.parseInt(st.nextToken());
			int e2 = Integer.parseInt(st.nextToken());
			
			edge[e1][e2] = true;
			edge[e2][e1] = true;
			
		}
		
		int count = 0;
		for(int i = 1; i <= N; i++) {
			
			if(visited[i] == false) {
				dfs(i);
				count++; // 연결요소++
			}
			
		}
		
		System.out.print(count);
		
		
		
	}
	
	public static void dfs(int v) {
		
		visited[v] = true;
		
		for(int i = 1; i <= N; i++) {
			if(edge[v][i] == true && visited[i] == false) {
				dfs(i);
			}
		}
		
	}
	
	

}
