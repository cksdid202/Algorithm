import java.util.*;
import java.io.*;

public class Solution {
	
    static int N, K, maxLen;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];
            int maxHeight = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }

            maxLen = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {
                        visited[i][j] = true;
                        dfs(i, j, map[i][j], false, 1);
                        visited[i][j] = false; 
                    }
                }
            }

            System.out.println("#" + t + " " + maxLen);
        }
    }

   
    static void dfs(int r, int c, int h, boolean used, int len) {
        maxLen = Math.max(maxLen, len);

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;

            if (map[nr][nc] < h) {
                visited[nr][nc] = true;
                dfs(nr, nc, map[nr][nc], used, len + 1);
                visited[nr][nc] = false;
            } 
            else if (!used && map[nr][nc] - K < h) {
                visited[nr][nc] = true;
                dfs(nr, nc, h - 1, true, len + 1);
                visited[nr][nc] = false;
            }
        }
    }
}