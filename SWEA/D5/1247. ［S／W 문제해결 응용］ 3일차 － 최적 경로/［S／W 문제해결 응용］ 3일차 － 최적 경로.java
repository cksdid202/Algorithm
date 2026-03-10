import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int N;
    static int cx, cy; // 회사 좌표
    static int hx, hy; // 집 좌표
    static int[][] customers; // 고객들 좌표 저장
    static boolean[] visited; 
    static int minPath; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 회사와 집 좌표
            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());
            hx = Integer.parseInt(st.nextToken());
            hy = Integer.parseInt(st.nextToken());
            
            // N명의 고객 좌표 
            customers = new int[N][2];
            for (int i = 0; i < N; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken()); // x
                customers[i][1] = Integer.parseInt(st.nextToken()); // y
            }
            
            visited = new boolean[N];
            minPath = Integer.MAX_VALUE; 
            
            // 탐색 (방문한 고객 수: 0, 현재 x좌표: 회사x, 현재 y좌표: 회사y, 이동 거리: 0)
            dfs(0, cx, cy, 0);
            
            sb.append("#").append(t).append(" ").append(minPath).append("\n");
        }
        System.out.print(sb);
    }
    
    // DFS (순열)
    static void dfs(int count, int x, int y, int dist) {
        
        // 백트래킹
        // 아직 다 방문하지 않았는데, 이미 최소 경로보다 거리가 길어졌다면 탐색 중단
        if (dist >= minPath) {
            return;
        }
        
        // [기저 조건] N명의 고객을 모두 방문
        if (count == N) {
            // 마지막 고객의 위치에서 집까지 가는 거리를 더해줌
            int totalDist = dist + Math.abs(x - hx) + Math.abs(y - hy);
            
            // 최소 경로 갱신
            if (totalDist < minPath) {
                minPath = totalDist;
            }
            return;
        }
        
        // 아직 방문하지 않은 고객들을 차례대로 방문 (N! 순열)
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                
                // 현재 위치에서 다음 고객 위치까지의 거리 계산
                int nextDist = dist + Math.abs(x - customers[i][0]) + Math.abs(y - customers[i][1]);
                
                // 다음 고객 위치로 이동
                dfs(count + 1, customers[i][0], customers[i][1], nextDist);
                
                visited[i] = false; // 다시 미방문 처리 백트래킹
            }
        }
    }
}                        