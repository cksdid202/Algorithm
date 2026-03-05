
import java.util.*;
import java.io.*;

public class Solution {
	
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};
    static int maxCnt = 0;
	
    public static void main(String[] args) throws Exception {
      
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int t = 0; t < T; t++) {
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		K = Integer.parseInt(st.nextToken());
    		
    		map = new int[N][N];
    		visited = new boolean[N][N];
    		int max = 0;
    		for(int i = 0; i < N; i++ ) {
    			st = new StringTokenizer(br.readLine());
    			
    			for(int j = 0; j < N; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    				if(max < map[i][j]) {
    					max = map[i][j];
    				}
    			}
    		}
    		for(int i = 0; i < N; i++) {
    			for(int j = 0; j < N; j++) {
    				if(map[i][j] == max) {
    					visited[i][j] = true;
    					dfs(i, j, 1, false, map[i][j]);
    					visited[i][j] = false;
    				}
    			}
    		}
    		
    		sb.append("#").append(t+1).append(" ").append(maxCnt).append("\n");
    		maxCnt = 0;
    		
    	}
    	System.out.print(sb);
    	
    	
    	
    	
    	
    	
    }
    				// r, c, 이동거리, 파낸적이 있는지, 현재 높이
    static void dfs(int r, int c, int cnt, boolean hasDug, int currentH) {
    
    	maxCnt = Math.max(maxCnt, cnt);
    	
    	for(int i = 0; i < 4; i++) {
    		
    		int nr = r + dr[i];
    		int nc = c + dc[i];
    		
    		if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
    			if(!visited[nr][nc]) {
    				
    				if(map[nr][nc] < currentH) {
    					visited[nr][nc] = true;
    					dfs(nr, nc, cnt+1, hasDug, map[nr][nc]);
    					visited[nr][nc] = false;
    				}
    				else if (map[nr][nc] - K < currentH && !hasDug) {
    					int nextH = currentH - 1 ;
    					visited[nr][nc] = true;
    					dfs(nr, nc, cnt+1, true, nextH);
    					visited[nr][nc] = false;
    				}
    				
    			}
    		}
    		
    		
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    
    }
}