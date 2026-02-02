
import java.util.*;
import java.io.*;

public class Solution {
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 10; t++) {
            int T = Integer.parseInt(br.readLine());
            
            map = new int[16][16];
            visited = new boolean[16][16];
            
            int startR = 0;
            int startC = 0;

            for (int i = 0; i < 16; i++) {
                String line = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    
                    if (map[i][j] == 2) {
                        startR = i;
                        startC = j;
                    }
                }
            }

            int result = bfs(startR, startC);
            sb.append("#").append(T).append(" ").append(result).append("\n");
        }
        
        System.out.print(sb);
    }

    public static int bfs(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16) {
                    
                    // 벽(1)이 아니고, 방문하지 않은 곳이라면
                    if (map[nr][nc] != 1 && !visited[nr][nc]) {
                        
                        // 도착점(3)이라면 즉시 성공(1) 반환
                        if (map[nr][nc] == 3) {
                            return 1;
                        }

                        // 아니면 계속 탐색 (큐에 넣기)
                        visited[nr][nc] = true;
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }
        }
        
        // 큐가 빌 때까지 3을 못 만나면 실패(0) 반환
        return 0;
    }
}
