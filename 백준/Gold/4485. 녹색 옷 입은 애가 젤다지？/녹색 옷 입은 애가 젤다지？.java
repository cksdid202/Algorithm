import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dist; 
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int r, c, cost;
        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; 
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break; 

            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF; 
                }
            }

            int result = solve();
            System.out.println("Problem " + tc + ": " + result);
            tc++;
        }
    }

    public static int solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[0][0] = map[0][0];
        pq.add(new Node(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.cost > dist[curr.r][curr.c]) continue;

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (dist[nr][nc] > dist[curr.r][curr.c] + map[nr][nc]) {
                        dist[nr][nc] = dist[curr.r][curr.c] + map[nr][nc];
                        pq.add(new Node(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }
        
        return dist[N - 1][N - 1]; 
    }
}