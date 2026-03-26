
import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, cnt = 0;
	static int r, c, d;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0}; // 상 동 남 서
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		clean(r, c);
		
		System.out.print(cnt);
		

	}
	
	public static void clean(int R, int C) {
		
		
		while(true) {
			if(!visited[R][C]) {
				visited[R][C] = true;
				cnt++;
			}
			int flag = 0;
			for(int i = 0; i < 4; i++) {
				int nr = R + dr[i];
				int nc = C + dc[i];
				if(!visited[nr][nc] && map[nr][nc] != 1 ) {
					flag = 1;
				}
			}
			if(flag == 0) {
				int nr = R + dr[(d+2)%4];
				int nc = C + dc[(d+2)%4];
				if(map[nr][nc] != 1) {
					R = nr;
					C = nc;
					continue;
				}
				else {
					break; // 종료
				}
			}
			else {
				d = d - 1;
				if(d == -1) {
					d = d + 4;
				}
				int nr = R + dr[d];
				int nc = C + dc[d];
				if(map[nr][nc] != 1 && !visited[nr][nc]) {
					R = nr;
					C = nc;
				}
			}
			
			
		}
		
		
	}
	
	
	
	
	
	

}
