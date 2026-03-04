
import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map;
	static boolean[][][] visited;
	static int N;
	static int M;
	static int K;
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
		visited = new boolean[N][M][K + 1];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		visited[0][0][0] = true;
		int result = bfs(0, 0);
		
		System.out.print(result);
		
		

	}
	
	static int bfs(int r, int c) {
		
		if (N == 1 && M == 1) return 1;
		
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {r, c, 1, 0}); // r, c, 이동거리, 벽 부수기 횟수
		
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			for(int i=0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr == N-1 && nc == M-1) {
					return cur[2]+1;
				}
				
				if(cur[3] < K) {
					if(isIn(nr, nc) && !visited[nr][nc][cur[3]+1] && map[nr][nc] == 1) {
						visited[nr][nc][cur[3]+1] = true;
						q.offer(new int[] {nr, nc, cur[2]+1, cur[3]+1});
					}
				}
				
				if(isIn(nr, nc) && !visited[nr][nc][cur[3]] && map[nr][nc] == 0) {
					visited[nr][nc][cur[3]] = true;
					q.offer(new int[] {nr, nc, cur[2]+1, cur[3]});
				}
			}

			
			
			
		}
		
		
		
		
		return -1;
		
		
		
	}
	
	static boolean isIn(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	

}
