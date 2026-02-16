import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        int maxHeight = 0; 

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }

        int maxSafeZones = 0; 

        // 완전 탐색
        // 비가 아예 오지 않는 경우(h=0)도 고려
        for(int h=0; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int currentCount = 0;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    // 방문하지 않았고, 건물 높이가 빗물(h)보다 높으면 안전 영역 시작
                    if(!visited[i][j] && map[i][j] > h) {
                        dfs(i, j, h); // 연결된 모든 안전 지역 탐색
                        currentCount++; 
                    }
                }
            }
            // 최댓값 갱신
            maxSafeZones = Math.max(maxSafeZones, currentCount);
        }

        System.out.println(maxSafeZones);
    }

    // DFS
    static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                // 방문 X, 침수되지 않은 곳이라면 계속 탐색
                if(!visited[nx][ny] && map[nx][ny] > h) {
                    dfs(nx, ny, h);
                }
            }
        }
    }
}