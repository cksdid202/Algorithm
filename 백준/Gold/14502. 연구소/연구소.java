import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static int[][] map;
    
    static ArrayList<int[]> emptySpaces = new ArrayList<>();
    static ArrayList<int[]> viruses = new ArrayList<>();
    
    static int maxSafeArea = 0; 
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }
        
        // 조합 탐색 시작: 빈칸 중 3개를 고르기 (고른 개수 0개, 0번 인덱스부터)
        combination(0, 0);
        
        System.out.println(maxSafeArea);
    }
    
    // 벽을 세울 3곳을 고르는 조합
    static void combination(int depth, int start) {
        // 기저 조건: 벽 3개를 다 세웠다면
        if (depth == 3) {
            spreadVirus(); // 바이러스를 퍼뜨리러 출발
            return;
        }
        
        // 빈칸 리스트에서 3개를 고름
        for (int i = start; i < emptySpaces.size(); i++) {
            int[] pos = emptySpaces.get(i);
            
            map[pos[0]][pos[1]] = 1; // 벽 세우기
            combination(depth + 1, i + 1); // 다음 벽 고르기 (조합 i + 1)
            map[pos[0]][pos[1]] = 0; // 되돌아오면 다시 벽 허물기
        }
    }
    
    // 바이러스를 퍼뜨리고 안전 영역을 세는 BFS
    static void spreadVirus() {
        // 원본 지도가 오염되면 안 되므로 복사본(tempMap) 생성
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            tempMap[i] = map[i].clone(); 
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        // 모든 바이러스 초기 위치를 큐에 
        for (int[] v : viruses) {
            q.offer(new int[]{v[0], v[1]});
        }
        
        // BFS 탐색 시작
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // 범위 안, 빈칸이면 감염
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (tempMap[nr][nc] == 0) {
                        tempMap[nr][nc] = 2; 
                        q.offer(new int[]{nr, nc}); // 새롭게 감염된 곳을 큐에 넣어 더 퍼지게 함
                    }
                }
            }
        }
        
        int safeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    safeCount++;
                }
            }
        }
        
        maxSafeArea = Math.max(maxSafeArea, safeCount);
    }
}