
import java.util.*;
import java.io.*;

public class Solution {
    
    static int N;
    static int[][] map;
    static int[][] memo; // (r,c)에서 출발해 갈 수 있는 최대 칸 수를 저장
    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            
            map = new int[N][N];
            memo = new int[N][N]; // 메모이제이션 배열 

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxCnt = 0;   // 최대 이동 횟수
            int startNum = 0; // 그때의 시작 방 번호

            // 모든 방을 순회하며 출발점으로 시도
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int cnt = dfs(i, j);

                    // 1. 이동 거리가 더 길면 무조건 갱신
                    if (cnt > maxCnt) {
                        maxCnt = cnt;
                        startNum = map[i][j];
                    }
                    // 2. 이동 거리가 같다면, 방 번호가 작은 것으로 갱신
                    else if (cnt == maxCnt) {
                        startNum = Math.min(startNum, map[i][j]);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(startNum).append(" ").append(maxCnt).append("\n");
        }
        
        System.out.print(sb);
    }

    /**
     * (r, c) 좌표에서 출발하여 이동할 수 있는 최대 칸 수를 반환하는 함수 (DFS + Memoization)
     */
    public static int dfs(int r, int c) {
        // 이미 계산한 적이 있다면 저장된 값 반환 (중복 연산 방지)
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        memo[r][c] = 1; // 자기 자신도 1칸 포함

        // 4방향 탐색
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위 안에 있고
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                // 다음 방 숫자가 정확히 현재 방 + 1 이라면 이동
                if (map[nr][nc] == map[r][c] + 1) {
                    // 재귀 호출 결과를 현재 메모 값에 더함
                    memo[r][c] += dfs(nr, nc);
                    break; // 숫자가 겹치지 않으므로, 갈 수 있는 길은 오직 하나뿐임 (더 이상 for문 돌 필요 없음)
                }
            }
        }

        return memo[r][c];
    }
}
