import java.util.*;
import java.io.*;

public class Main {
	
	static int R, C, maxCnt = 0;
	static char[][] map;
    
	static boolean[] alphaCheck = new boolean[26]; 
    
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		alphaCheck[map[0][0] - 'A'] = true;
		
		dfs(0, 0, 1); // 1칸 시작
		
		System.out.print(maxCnt);
	}
	
	public static void dfs(int r, int c, int cnt) {
		
		if(cnt > maxCnt) {
			maxCnt = cnt;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
                // 다음 칸 숫자 변환
                int nextAlpha = map[nr][nc] - 'A';
                
                // 배열 인덱스로 검사
				if(!alphaCheck[nextAlpha]) {
                    alphaCheck[nextAlpha] = true;  
                    dfs(nr, nc, cnt + 1);          
                    alphaCheck[nextAlpha] = false; 
				}
			}
		}
	}
}