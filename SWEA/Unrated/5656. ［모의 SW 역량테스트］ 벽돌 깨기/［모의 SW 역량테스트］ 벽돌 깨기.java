import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    
    static int N, W, H, min;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 쏘는 횟수
            W = Integer.parseInt(st.nextToken()); // 가로 
            H = Integer.parseInt(st.nextToken()); // 세로 
            
            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            min = Integer.MAX_VALUE;
            
            dfs(0, map);
            
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }
    
    static void dfs(int depth, int[][] map) {
        // 가지치기: 이미 남은 벽돌이 0개
        if (min == 0) return;
        
        // 기저 조건: 구슬을 N번 다 쐈다면
        if (depth == N) {
            int count = getRemain(map);
            min = Math.min(min, count);
            return;
        }
        
        // 0번 열부터 W-1번 열까지 어디에 구슬을 떨어뜨릴지 결정
        for (int c = 0; c < W; c++) {
            // 현재 맵의 상태를 훼손하면 안 되므로 복사본 생성
            int[][] nextMap = copyMap(map);
            
            // 해당 열(c)에서 가장 위에 있는 벽돌 찾기
            int r = 0;
            while (r < H && nextMap[r][c] == 0) {
                r++;
            }
            
            // 만약 해당 열에 벽돌이 아예 없다면 폭발 패스하고 다음 구슬 쏘러 감
            if (r == H) {
                dfs(depth + 1, nextMap);
            } else {
                // 벽돌이 있다면 폭발시키고 -> 빈 공간 채우고 -> 다음 구슬 쏘러 감
                explode(nextMap, r, c); 
                gravity(nextMap);       
                dfs(depth + 1, nextMap);
            }
        }
    }
    
    // 연쇄 폭발 (BFS)
    static void explode(int[][] map, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        
        // 벽돌의 숫자가 1보다 클 때만 큐에 넣음 (1이면 본인만 터지고 끝이므로 큐에 넣을 필요 없음)
        if (map[r][c] > 1) {
            q.offer(new int[]{r, c, map[r][c]});
        }
        map[r][c] = 0; // 명중한 벽돌 파괴 (0으로 만듦)
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int power = cur[2];
            
            // 상하좌우 4방향으로 (power - 1)만큼 터짐
            for (int i = 0; i < 4; i++) {
                int nr = curR;
                int nc = curC;
                
                // 파워-1 만큼 해당 방향으로 뻗어나감
                for (int p = 1; p < power; p++) {
                    nr += dr[i];
                    nc += dc[i];
                    
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
                        if (map[nr][nc] > 1) {
                            q.offer(new int[]{nr, nc, map[nr][nc]});
                        }
                        map[nr][nc] = 0; // 터진 벽돌은 0으로
                    }
                }
            }
        }
    }
    
    // 중력 작용 (빈 공간 메우기)
    static void gravity(int[][] map) {
        for (int c = 0; c < W; c++) {
            int targetRow = H - 1; // 바닥부터 채워 올라갈 인덱스
            
            // 밑에서부터 위로 훑으면서 벽돌(0이 아닌 것)을 발견하면 바닥으로 끌어내림
            for (int r = H - 1; r >= 0; r--) {
                if (map[r][c] != 0) {
                    // 현재 위치와 옮겨야 할 타겟 위치가 다르다면 옮기고 원래 자리는 0으로 만듦
                    if (r != targetRow) {
                        map[targetRow][c] = map[r][c];
                        map[r][c] = 0;
                    }
                    targetRow--;
                }
            }
        }
    }
    
    // 배열 복사 유틸 메서드
    static int[][] copyMap(int[][] map) {
        int[][] temp = new int[H][W];
        for (int i = 0; i < H; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
    }
    
    // 남은 벽돌 개수 카운트
    static int getRemain(int[][] map) {
        int count = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] > 0) count++;
            }
        }
        return count;
    }
}