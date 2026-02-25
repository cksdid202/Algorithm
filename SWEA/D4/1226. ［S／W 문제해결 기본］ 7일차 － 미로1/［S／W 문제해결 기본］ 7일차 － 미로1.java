
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 이 문제는 무조건 10개의 테스트 케이스가 주어집니다.
        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 번호 읽기
            
            map = new char[16][16];
            visited = new boolean[16][16];
            
            int startR = -1;
            int startC = -1;

            // 16x16 미로 입력받기
            for (int i = 0; i < 16; i++) {
                String line = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = line.charAt(j);
                    
                    // 출발점(2) 좌표를 찾으면 저장해둡니다.
                    if (map[i][j] == '2') {
                        startR = i;
                        startC = j;
                    }
                }
            }

            // BFS 탐색 시작 (도착하면 1, 못 하면 0 반환)
            int result = dfs(startR, startC);
            
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        
        System.out.print(sb);
    }

    // BFS 탐색 로직
    public static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];

            // 큐에서 꺼낸 현재 위치가 도착점(3)이라면 탐색 성공!
            if (map[curR][curC] == '3') {
                return 1;
            }

            // 상하좌우 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                // 1. 미로 범위를 벗어나지 않고 (0 ~ 15)
                if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16) {
                    // 2. 벽('1')이 아니며, 아직 방문하지 않은 길이라면 이동 가능
                    if (map[nr][nc] != '1' && !visited[nr][nc]) {
                        visited[nr][nc] = true; // 방문 처리
                        q.offer(new int[]{nr, nc}); // 큐에 넣고 다음 탐색 대기
                    }
                }
            }
        }
        
        // 큐가 다 빌 때까지 '3'을 못 만났다면 갈 수 없는 미로임
        return 0; 
    }
    
    public static int dfs(int r, int c) {
    	
    	visited[r][c] = true;
    	
    	if (map[r][c] == '3') {
            return 1;
        }
    	
    	for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16) {
                if (map[nr][nc] != '1' && !visited[nr][nc]) {
                    visited[nr][nc] = true; // 방문 처리
                    if(dfs(nr, nc) == 1) {
                    	return 1;
                    }
                }
            }
        }
    	
    	return 0;
    	
    	
    	
    }
    
    
    
}
