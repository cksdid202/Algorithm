
import java.util.*;
import java.io.*;

public class Main {
	
	static int R, C, cnt, maxCnt=0;
	static char[][] map;
	static boolean[][] visited;
	static char[] charlist;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		charlist = new char[R*C];
		
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j); 
			}
		}
		visited[0][0] = true;
		charlist[0] = map[0][0];
		
		bfs(0, 0, visited, 1);
		
		System.out.print(maxCnt);
		
		
		
	}
	
	public static void bfs(int r, int c, boolean[][] visited, int cnt) {
		
		if(cnt > maxCnt) {
			maxCnt = cnt;
		}
		
		for(int i = 0; i < 4; i++) {
			
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if(!visited[nr][nc]) {
					int flag = 0;
					for(int j = 0; j < cnt; j++) {
						if(map[nr][nc] == charlist[j] ) {
							flag = 1;
							break;
						}
					}
					if(flag == 0) {
							visited[nr][nc] = true;
							charlist[cnt] = map[nr][nc];
							bfs(nr, nc, visited, cnt+1);
							visited[nr][nc] = false;
					}
					
					
				}
			}
			
		}
		
		
	}
	

}
