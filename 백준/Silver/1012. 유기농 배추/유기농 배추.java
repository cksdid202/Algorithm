
import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int M;
	static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new boolean[N][M];
			visited = new boolean[N][M];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				map[r][c] = true;
				
				
			}
			
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					
					if(map[i][j] == true && visited[i][j] == false) {
						dfs(i, j);
						count++;
					}
					
					
					
				}
			}
			sb.append(count).append("\n");
			
			
			
		}
		System.out.print(sb);
		
		
		
		
		
	}
	
	public static void dfs(int r, int c) {
		
		visited[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if(map[nr][nc] == true && visited[nr][nc] == false) {
					dfs(nr, nc);
				}
			}
		}
		
		
		
		
		
		
	}
	

}
