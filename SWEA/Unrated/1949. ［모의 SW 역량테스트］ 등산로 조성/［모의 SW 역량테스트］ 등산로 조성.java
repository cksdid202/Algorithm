
import java.io.*;
import java.util.*;

public class Solution {

    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int maxLen; 

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); 
            K = Integer.parseInt(st.nextToken()); 

            map = new int[N][N];
            visited = new boolean[N][N];
            maxLen = 0;
            int maxHeight = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {
                        visited[i][j] = true;
                        //( r, c, 현재 등산로 길이, 공사 여부, 현재 밟고 있는 높이)
                        dfs(i, j, 1, false, map[i][j]); 
                        visited[i][j] = false; // 다른 출발점을 위해 방문 기록 초기화
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(maxLen).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int r, int c, int len, boolean hasDug, int currentHeight) {
    
    	maxLen = Math.max(maxLen, len);
    	
    	for(int i = 0; i < 4; i++) {
    		int nr = r + dr[i];
    		int nc = c + dc[i];
    		
    		if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
    			
    			// 공사를 했든 안 했든 다음으로 갈 수 있을 때.
    			if(map[nr][nc] < currentHeight && !visited[nr][nc]) {
    				visited[nr][nc] = true;
    				dfs(nr, nc, len+1, hasDug, map[nr][nc]);
    				visited[nr][nc] = false;
    			} // 다음으로 못 가는데 공사를 할 수 있을 때 공사.
    			else if(!hasDug && map[nr][nc] - K < currentHeight && !visited[nr][nc]) {
    				visited[nr][nc] = true;
    				dfs(nr, nc, len+1, true, currentHeight-1);
    				visited[nr][nc] = false;
    			}
    			
    			
    		}
    		
    		
    		
    		
    		
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    
    }
}