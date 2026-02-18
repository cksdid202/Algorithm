import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static boolean[][] graph; // 인접 행렬
    static boolean[] visited; 
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        V = Integer.parseInt(st.nextToken()); 

        // 1번부터 시작하므로 N+1 크기로 생성
        graph = new boolean[N + 1][N + 1];
        
        // 간선 정보 양방향
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a][b] = true;
            graph[b][a] = true;
        }

        // DFS
        visited = new boolean[N + 1]; // 방문 배열 초기화
        dfs(V);
        sb.append("\n");

        // BFS
        visited = new boolean[N + 1]; // 방문 배열 초기화 (다시 써야 됨)
        bfs(V);

        System.out.println(sb);
    }

    // DFS 재귀
    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        // 번호가 작은 것부터 방문하기 위해 1부터 N까지 순차 탐색
        for (int i = 1; i <= N; i++) {
            if (graph[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    // BFS 큐 사용
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");

            // 현재 정점과 연결된 노드들 탐색
            for (int i = 1; i <= N; i++) {
                if (graph[current][i] && !visited[i]) {
                    q.offer(i);
                    visited[i] = true; // 큐에 넣을 때 방문 처리
                }
            }
        }
    }
}