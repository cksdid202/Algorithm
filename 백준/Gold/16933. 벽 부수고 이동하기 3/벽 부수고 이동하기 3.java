
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M, K;
    static char[][] map;
    static boolean[][][] visited; // r, c, 벽 부순 횟수
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        // 예외 처리
        if (N == 1 && M == 1) return 1;

        Queue<int[]> q = new ArrayDeque<>();
        
        // r, c, 이동 거리, 부순 횟수, 낮/밤
        q.offer(new int[]{0, 0, 1, 0, 1});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            int k = cur[3];
            int isDay = cur[4];

            // 제자리에서 기다리는 큐가 중복으로 들어가는 것을 막기 위한 플래그
            boolean waited = false; 

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr == N - 1 && nc == M - 1) {
                    return dist + 1; // 종료
                }

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    
                    if (map[nr][nc] == '0') {
                        if (!visited[nr][nc][k]) {
                            visited[nr][nc][k] = true;
                            // 낮밤 상태를 뒤집
                            q.offer(new int[]{nr, nc, dist + 1, k, 1 - isDay});
                        }
                    } 
                    
                    else if (map[nr][nc] == '1' && k < K) {
                        if (!visited[nr][nc][k + 1]) {
                            
                            if (isDay == 1) {
                                visited[nr][nc][k + 1] = true;
                                q.offer(new int[]{nr, nc, dist + 1, k + 1, 0});
                            } else {
                                // 밤 - 제자리에서 하루 대기
                                // 단, 4방향을 검사하다가 '대기' 상태를 큐에 여러 번 넣으면 메모리가 터지므로 플래그 확인
                                if (!waited) {
                                    // 내 위치(r, c) 그대로, 거리만 +1, 낮(1)으로 바뀌어 큐에 들어감
                                    q.offer(new int[]{r, c, dist + 1, k, 1});
                                    waited = true; // 이번 턴에서는 한 번만 기다리기로 약속
                                }
                            }
                        }
                    }
                }
            }
        }

        // 도달 불가능
        return -1;
    }
}