
import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map;
	static boolean[][][] visited;
	static int W;
	static int H;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] horseR = {-2, -1, 1, 2, 2, 1, -1, -2}; // 1시부터 시계방향
	static int[] horseC = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K + 1 ];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		visited[0][0][0] = true;
		int result = bfs(0, 0, K);
		
		System.out.print(result);
		
		

	}
	
	static int bfs(int r, int c, int K) {
		
		if (H == 1 && W == 1) return 0;
		
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {r, c, 0, 0}); // r, c, 이동거리, 말 능력
		
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			for(int i=0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr == H-1 && nc == W-1) {
					return cur[2]+1;
				}
				
				if(isIn(nr, nc) && !visited[nr][nc][cur[3]] && map[nr][nc] == 0) {
					visited[nr][nc][cur[3]] = true;
					q.offer(new int[] {nr, nc, cur[2]+1, cur[3]});
				}
			}
			if(cur[3] < K) { // 능력이 있으면
				for(int i=0; i < 8; i++) {
					int nr = cur[0] + horseR[i];
					int nc = cur[1] + horseC[i];
					
					if(nr == H-1 && nc == W-1) {
						return cur[2]+1;
					}
					
					if(isIn(nr, nc) && !visited[nr][nc][cur[3]+1] && map[nr][nc] == 0) {
						visited[nr][nc][cur[3]+1] = true;
						q.offer(new int[] {nr, nc, cur[2]+1, cur[3]+1});
					}
				}
			}

			
			
			
		}
		
		
		
		
		return -1;
		
		
		
	}
	
	static boolean isIn(int nr, int nc) {
		if(nr >= 0 && nr < H && nc >= 0 && nc < W) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	

}
