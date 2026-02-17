import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] graph; 
    static boolean[] visited; 
    static int N, M;
    static int result = 0; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); 
        M = Integer.parseInt(br.readLine()); 

        // 인덱스 1부터
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a][b] = true;
            graph[b][a] = true;
        }

        dfs(1);

        System.out.println(result);
    }

    static void dfs(int start) {
        visited[start] = true; 

        // 1번부터 N번 컴퓨터까지 순회하며 연결되어 있는지 확인
        for (int i = 1; i <= N; i++) {
            // 연결되어 있고, 아직 방문하지 않았다면
            if (graph[start][i] && !visited[i]) {
                result++; 
                dfs(i);   // 해당 컴퓨터로 탐색 (재귀)
            }
        }
    }
}