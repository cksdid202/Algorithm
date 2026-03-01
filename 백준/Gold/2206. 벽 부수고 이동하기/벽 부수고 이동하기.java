
import java.util.*;
import java.io.*;
public class Main {

    static int[][] map;
    static boolean[][][] visited;
    static int N;
    static int M;
    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];

        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                char ch = str.charAt(j-1);
                map[i][j] = ch - '0';
            }
        }
        int result = bfs(1, 1);
        System.out.print(result);

    }

    static int bfs(int r, int c) {

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{r, c, 1, 0}); // r, c, 이동거리, 벽 부수기 여부
        visited[r][c][0] = true;


        while(!q.isEmpty()) {

            int[] cur = q.poll();
            if(cur[0] == N && cur[1] == M) {
                return cur[2];
            }
            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr >= 1 && nr <= N && nc >= 1 && nc <= M) { // isIn
                    if(map[nr][nc] == 1) { // 벽이면
                        if(cur[3] == 0 && !visited[nr][nc][1]) { // 부순 상태인 얘가 가본적 없으면
                            visited[nr][nc][1] = true;
                            q.offer(new int[]{nr, nc, cur[2]+1, cur[3]+1});
                        }
                    }
                    else { // 벽이 아니면
                        if(!visited[nr][nc][cur[3]]) {
                            visited[nr][nc][cur[3]] = true;
                            q.offer(new int[]{nr, nc, cur[2]+1, cur[3]});
                        }
                    }
                }
            }


        }
        return -1;




    }




}