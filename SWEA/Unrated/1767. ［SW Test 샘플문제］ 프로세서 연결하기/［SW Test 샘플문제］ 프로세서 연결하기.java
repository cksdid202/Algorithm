
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// gg gemini 어려워
public class Solution {
    
    static int N;
    static int[][] map;
    static ArrayList<int[]> cores; // 가장자리가 아닌 코어들의 위치 저장
    static int maxCore; // 최대 연결 코어 수
    static int minWireLen; // 최소 전선 길이
    
    // 상, 하, 좌, 우 델타
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            cores = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    // 가장자리에 있는 코어는 이미 연결된 것으로 간주하므로 리스트에 넣지 않음
                    if (map[i][j] == 1) {
                        if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                            continue;
                        }
                        cores.add(new int[]{i, j});
                    }
                }
            }

            maxCore = Integer.MIN_VALUE;
            minWireLen = Integer.MAX_VALUE;

            // DFS 탐색 시작 (첫 번째 코어부터)
            dfs(0, 0, 0);

            sb.append("#").append(t).append(" ").append(minWireLen).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * @param idx      현재 고려 중인 코어의 인덱스
     * @param cnt      현재까지 연결된 코어의 개수
     * @param wireLen  현재까지 설치된 전선의 길이 합
     */
    static void dfs(int idx, int cnt, int wireLen) {
        // [기저 조건] 모든 코어를 다 고려했을 때
        if (idx == cores.size()) {
            // 1. 연결된 코어 개수가 더 많으면 무조건 갱신
            if (cnt > maxCore) {
                maxCore = cnt;
                minWireLen = wireLen;
            } 
            // 2. 코어 개수가 같으면, 전선 길이가 더 짧은 쪽으로 갱신
            else if (cnt == maxCore) {
                minWireLen = Math.min(minWireLen, wireLen);
            }
            return;
        }

        int r = cores.get(idx)[0];
        int c = cores.get(idx)[1];

        // 4방향 탐색 (상, 하, 좌, 우)
        for (int d = 0; d < 4; d++) {
            int count = 0; // 현재 방향으로 설치할 수 있는 전선 길이
            int nr = r;
            int nc = c;

            // 해당 방향으로 쭉 뻗어보기 (전선 설치 가능 여부 확인)
            while (true) {
                nr += dr[d];
                nc += dc[d];

                // 범위를 벗어나면 전원(가장자리)에 닿은 것 -> 성공
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    break;
                }

                // 다른 코어나 전선을 만나면 -> 실패 (이 방향은 불가)
                if (map[nr][nc] == 1) {
                    count = 0;
                    break;
                }
                
                count++; // 전선 길이 증가
            }

            // 전원까지 연결이 가능하다면
            if (count > 0) {
                // 1. 전선 설치 (map에 1로 표시)
                fill(r, c, d, count, 1);
                
                // 2. 다음 코어로 이동 (연결 성공했으므로 cnt+1, wireLen+count)
                dfs(idx + 1, cnt + 1, wireLen + count);
                
                // 3. 백트래킹 (전선 해제: map을 다시 0으로)
                fill(r, c, d, count, 0);
            }
        }

        // 해당 코어를 '연결하지 않고' 건너뛰는 경우도 반드시 고려해야 함
        // (그래야 다른 코어를 연결해서 전체적으로 이득을 볼 수도 있음)
        dfs(idx + 1, cnt, wireLen);
    }

    // 전선을 설치하거나 해제하는 함수
    // type: 1(설치), 0(해제)
    static void fill(int r, int c, int d, int count, int type) {
        int nr = r;
        int nc = c;
        for (int i = 0; i < count; i++) {
            nr += dr[d];
            nc += dc[d];
            map[nr][nc] = type;
        }
    }
}
