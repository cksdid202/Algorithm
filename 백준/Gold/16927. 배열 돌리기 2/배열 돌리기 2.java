import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void solve() {
        int layers = Math.min(N, M) / 2;

        for (int l = 0; l < layers; l++) {
            int height = N - 2 * l;
            int width = M - 2 * l;
            int cycleLen = 2 * (height - 1) + 2 * (width - 1);

            int actualR = R % cycleLen;

            for (int r = 0; r < actualR; r++) {
                rotateLayer(l);
            }
        }
    }

    public static void rotateLayer(int l) {
        int r = l;
        int c = l;
        int firstValue = map[r][c];

        // 상단 
        for (int j = l; j < M - 1 - l; j++) {
            map[l][j] = map[l][j + 1];
        }
        // 우측 
        for (int i = l; i < N - 1 - l; i++) {
            map[i][M - 1 - l] = map[i + 1][M - 1 - l];
        }
        // 하단 
        for (int j = M - 1 - l; j > l; j--) {
            map[N - 1 - l][j] = map[N - 1 - l][j - 1];
        }
        // 좌측 
        for (int i = N - 1 - l; i > l; i--) {
            map[i][l] = map[i - 1][l];
        }

        map[l + 1][l] = firstValue;
    }
}