import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int[] pop; // 각 구역의 인구수
    static ArrayList<Integer>[] adj; // 인접 리스트 (구역 연결 상태)
    static boolean[] selected; // true: A선거구, false: B선거구
    static int minDiff = Integer.MAX_VALUE; // 인구 차이의 최솟값 (정답)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        pop = new int[N + 1];
        selected = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pop[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>(); 
        }
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken()); // 인접한 구역의 수
            for (int j = 0; j < count; j++) {
                int neighbor = Integer.parseInt(st.nextToken());
                adj[i].add(neighbor); 
            }
        }
        
        divide(1);
        
        if (minDiff == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDiff);
        }
    }
    
    static void divide(int idx) {
        // N번 구역까지 모두 소속을 결정했다면
        if (idx == N + 1) {
            // 두 선거구가 유효한지(서로 연결되어 있고 1개 이상인지) 확인
            if (isValid()) {
                // 유효하다면 인구수 차이를 구해서 최솟값 갱신
                calcDifference();
            }
            return;
        }
        
        // 현재 구역을 A선거구(true)로 배정
        selected[idx] = true;
        divide(idx + 1);
        
        // 현재 구역을 B선거구(false)로 배정
        selected[idx] = false;
        divide(idx + 1);
    }
    
    static boolean isValid() {
        boolean[] visited = new boolean[N + 1];
        
        // A선거구(true)에 속한 임의의 한 구역 찾기
        int areaA = -1;
        for (int i = 1; i <= N; i++) {
            if (selected[i]) {
                areaA = i;
                break;
            }
        }
        
        // B선거구(false)에 속한 임의의 한 구역 찾기
        int areaB = -1;
        for (int i = 1; i <= N; i++) {
            if (!selected[i]) {
                areaB = i;
                break;
            }
        }
        
        if (areaA == -1 || areaB == -1) return false;
        
        // A선거구 연결 확인 (BFS)
        bfs(areaA, true, visited);
        // B선거구 연결 확인 (BFS)
        bfs(areaB, false, visited);
        
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) return false;
        }
        
        return true;
    }
    
    static void bfs(int start, boolean team, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            // 현재 구역과 연결된 이웃들을 모두 살피면서
            for (int next : adj[cur]) {
                // 아직 방문 안 했고 && 나랑 같은 팀(선거구)이라면 큐에 넣고 계속 탐색
                if (!visited[next] && selected[next] == team) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
    
    static void calcDifference() {
        int popA = 0, popB = 0;
        for (int i = 1; i <= N; i++) {
            if (selected[i]) popA += pop[i];
            else popB += pop[i];
        }
        
        int diff = Math.abs(popA - popB); // 절댓값 계산
        minDiff = Math.min(minDiff, diff);
    }
}