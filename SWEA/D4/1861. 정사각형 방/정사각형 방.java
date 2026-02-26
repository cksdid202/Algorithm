
import java.util.*;
import java.io.*;

public class Solution {
	
	
	static int cnt = 0;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	static int N;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N+1][N+1];
			
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
				
			}
			
			int resultCnt = 0;
			int resultI = 0;
			
			for(int i = 1; i <= N; i++) {
				
				
				for(int j = 1; j <= N; j++) {
					
					// -----------------------
					boolean isMiddle = false;
			        for (int d = 0; d < 4; d++) {
			            int ni = i + dr[d];
			            int nj = j + dc[d];
			            // 내 주변에 '나보다 1 작은 방'이 있다면 나는 중간 지점임
			            if (ni > 0 && ni <= N && nj > 0 && nj <= N) {
			                if (map[i][j] - map[ni][nj] == 1) {
			                    isMiddle = true;
			                    break;
			                }
			            }
			        }
			        
			        // 중간 지점이면 어차피 최대 길이가 될 수 없으므로 스킵!
			        if (isMiddle) continue; 
			        // -------------------------
					
					dfs(i, j);
					if(cnt > resultCnt) {
						resultI = map[i][j];
						resultCnt = cnt; 
					}
					else if (cnt == resultCnt) {
						resultI = Math.min(map[i][j], resultI);
					}
					
					cnt = 0;
				}
				
			}
			
			sb.append("#").append(t+1).append(" ").append(resultI).append(" ").append(resultCnt).append("\n");		
			
			
		}
		
		System.out.print(sb);
		
		
		
	}
	
	static public void dfs(int r, int c) {
		
		
		cnt++;
		
		for(int i = 0; i < 4; i++) {
			
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr > 0 && nr <= N && nc > 0 && nc <= N) {
				if(map[nr][nc] - map[r][c] == 1) {
					dfs(nr, nc);
				}
			}
			
		}
		
		
	}
	
	
	
	
	

}
