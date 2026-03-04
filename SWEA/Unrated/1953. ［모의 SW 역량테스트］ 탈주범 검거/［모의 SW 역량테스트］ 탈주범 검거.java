
import java.util.*;
import java.io.*;

public class Solution {
    
    static int N, M, R, C, L;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    // 파이프 번호(1~7)에 따라 갈 수 있는 방향을 배열로 지정
    // 예: 2번 파이프는 상(0), 하(1)로만 갈 수 있음
    static int[][] pipe = {
        {}, // 0번은 빈 공간
        {0, 1, 2, 3}, // 1번: 십자 (상, 하, 좌, 우)
        {0, 1},       // 2번: 수직 (상, 하)
        {2, 3},       // 3번: 수평 (좌, 우)
        {0, 3},       // 4번: ㄴ자 (상, 우)
        {1, 3},       // 5번: r자 (하, 우)
        {1, 2},       // 6번: ㄱ자 (하, 좌)
        {0, 2}        // 7번: J자 (상, 좌)
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지도 세로 크기
            M = Integer.parseInt(st.nextToken()); // 지도 가로 크기
            R = Integer.parseInt(st.nextToken()); // 맨홀(출발지) 세로 위치
            C = Integer.parseInt(st.nextToken()); // 맨홀(출발지) 가로 위치
            L = Integer.parseInt(st.nextToken()); // 탈출 소요 시간
            
            map = new int[N][M];
            visited = new boolean[N][M];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // BFS 탐색을 돌리고 결과(갈 수 있는 칸의 수)를 바로 sb에 저장
            sb.append("#").append(t).append(" ").append(bfs()).append("\n");
        }
        System.out.print(sb);
    }
    
    static int bfs() {
        
    	Queue<int[]> q = new ArrayDeque<>();
    	
    	q.offer(new int[] {R, C, 1});
    	visited[R][C] = true;
    	
    	int count = 1;
    	
    	while(!q.isEmpty()) {
    		
    		int[] cur = q.poll();
    		
    		if(cur[2] == L) continue;
    		
    		for(int dir : pipe[map[cur[0]][cur[1]]]) {
    			
    			int nr = cur[0] + dr[dir];
    			int nc = cur[1] + dc[dir];
    			
    			if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
    				
    				int nextPipe = map[nr][nc];
    				if(isConnected(dir, nextPipe)) {
    					visited[nr][nc] = true;
    					q.offer(new int[] {nr, nc, cur[2]+1});
    					count++;
    				}
    				
    			}
    			
    		}
    		
    		
    		
    	}
    	
    	return count;
    	
    }
    
    static boolean isConnected(int dir, int nextPipe) {
        // 상 -> 다음 파이프는 아래(하)가 뚫려있어야 함 (1, 2, 5, 6번)
        if (dir == 0) return nextPipe == 1 || nextPipe == 2 || nextPipe == 5 || nextPipe == 6;
        
        // 하 -> 다음 파이프는 위(상)가 뚫려있어야 함 (1, 2, 4, 7번)
        if (dir == 1) return nextPipe == 1 || nextPipe == 2 || nextPipe == 4 || nextPipe == 7;
        
        // 좌 -> 다음 파이프는 오른쪽(우)이 뚫려있어야 함 (1, 3, 4, 5번)
        if (dir == 2) return nextPipe == 1 || nextPipe == 3 || nextPipe == 4 || nextPipe == 5;
        
        // 우 -> 다음 파이프는 왼쪽(좌)이 뚫려있어야 함 (1, 3, 6, 7번)
        if (dir == 3) return nextPipe == 1 || nextPipe == 3 || nextPipe == 6 || nextPipe == 7;
        
        return false;
    }
}