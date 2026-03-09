import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int N;
    static char[][] map;
    static int[][] mineCount; // 각 칸의 주변 지뢰 개수를 저장할 배열
    static boolean[][] visited;
    
    // 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하 
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            mineCount = new int[N][N];
            visited = new boolean[N][N];
            
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }
            
            // 모든 칸에 대해 주변(8방향) 지뢰 개수를 미리 계산해 둠
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == '.') {
                        int count = 0;
                        for (int i = 0; i < 8; i++) {
                            int nr = r + dr[i];
                            int nc = c + dc[i];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                if (map[nr][nc] == '*') count++;
                            }
                        }
                        mineCount[r][c] = count;
                    }
                }
            }
            
            int clicks = 0;
            
            // 주변 지뢰가 '0'인 칸들을 먼저 모조리 클릭해서 연쇄 폭발시키기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    // 빈칸이고, 주변 지뢰가 0개이며, 아직 안 열린 곳이라면 클릭
                    if (map[r][c] == '.' && mineCount[r][c] == 0 && !visited[r][c]) {
                        clicks++;
                        bfs(r, c); // 연쇄 폭발 시작
                    }
                }
            }
            
            // 연쇄 폭발로도 열리지 않은 나머지 칸들 직접 클릭하기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    // 지뢰가 아닌데 아직 방문(클릭) 안 된 곳
                    if (map[r][c] == '.' && !visited[r][c]) {
                        clicks++;
                    }
                }
            }
            
            sb.append("#").append(t).append(" ").append(clicks).append("\n");
        }
        System.out.print(sb);
    }
    
    // 연쇄 폭발을 처리하는 BFS
    static void bfs(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startR, startC});
        visited[startR][startC] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            // 8방향으로 연쇄 폭발 전파
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    // 빈칸이고 아직 안 열렸다면
                    if (map[nr][nc] == '.' && !visited[nr][nc]) {
                        visited[nr][nc] = true; // 일단 방문(열림) 처리
                        
                        // 열린 칸이 또 0이라면 그 칸을 중심으로 다시 연쇄 폭발이 일어나야 하므로 큐에 넣음
                        // 0이 아니면 열리기만 하고 폭발은 멈추므로 큐에 넣지 않음
                        if (mineCount[nr][nc] == 0) {
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
    }
}