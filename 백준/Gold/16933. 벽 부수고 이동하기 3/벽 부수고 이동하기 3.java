
import java.util.*;
import java.io.*;

public class Main {

	static int N, M, K;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][K+1];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.print(bfs(0, 0));
		
		
	}
	
	static int bfs(int r, int c) {
		
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {r, c, 1, 0, 0}); // r, c, 이동거리, 벽부순횟수, 낮 0 밤 1 
		visited[r][c][0] = true;
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			if(cur[0] == N-1 && cur[1] == M-1) {
				return cur[2];
			}
			
			for(int i = 0; i < 4; i++) {
				
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					
					if(map[nr][nc] == 0) { // 벽이 아니면
						if(!visited[nr][nc][cur[3]]) {
							visited[nr][nc][cur[3]] = true;
							if(cur[4] == 1) {
								q.offer(new int[] {nr, nc, cur[2]+1, cur[3], 0});
							}
							else {
								q.offer(new int[] {nr, nc, cur[2]+1, cur[3], 1});
							}
						}
						
						
					}
					else if (map[nr][nc] == 1 && cur[3] < K){ // 벽이면
						
						if(!visited[nr][nc][cur[3]+1]) {
							if(cur[4] == 0) { // 낮이면
								
								visited[nr][nc][cur[3]+1] = true;
								q.offer(new int[] {nr, nc, cur[2]+1, cur[3]+1, 1});
							}
							else { // 밤이면
								q.offer(new int[] {cur[0], cur[1], cur[2]+1, cur[3], 0});
							}
						}
						
					}
					
				}
				
			}
		}
		
		return -1;
		
		
		
	}

}
