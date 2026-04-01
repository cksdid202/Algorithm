import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, startR, startC;
	static int[][] map;
	static boolean[][] visited;
	static int[][] result;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		result = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					result[i][j] = -1;
				}
				if(map[i][j] == 2) {
					startR = i;
					startC = j;
				}
			}
			
		}
		visited = new boolean[n][m];
		bfs(startR, startC);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
		
		
		
	}
	
	public static void bfs (int r, int c) {
		
		Queue<int[]> q = new ArrayDeque<>();
		
		visited[r][c] = true;
		result[r][c] = 0;
		q.offer(new int[] {r, c});
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
		
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
					if(!visited[nr][nc] && map[nr][nc] != 0) {
						visited[nr][nc] = true;
						result[nr][nc] = result[cur[0]][cur[1]] + 1;
						q.offer(new int[] {nr, nc});
					}
				}
			}
			
		}
		
		
		
	}
	
	
	

}
