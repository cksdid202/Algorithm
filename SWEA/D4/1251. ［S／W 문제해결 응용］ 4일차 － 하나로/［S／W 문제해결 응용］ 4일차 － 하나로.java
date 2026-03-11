import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    
    // 도착할 섬의 번호와, 그 섬까지 다리를 놓는 비용(거리 제곱)을 담을 클래스
    static class Node implements Comparable<Node> {
        int to;
        long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        // 우선순위 큐에서 가장 저렴한 다리가 먼저 나오도록 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            long[] x = new long[N];
            long[] y = new long[N];

            StringTokenizer stX = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) x[i] = Long.parseLong(stX.nextToken());
            
            StringTokenizer stY = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) y[i] = Long.parseLong(stY.nextToken());

            double E = Double.parseDouble(br.readLine());

            boolean[] visited = new boolean[N]; // 섬 방문 여부 (MST 포함 여부)
            PriorityQueue<Node> pq = new PriorityQueue<>();

            pq.offer(new Node(0, 0));

            long totalWeight = 0; 
            int count = 0; 

            // 프림
            while (!pq.isEmpty()) {
                // 현재 놓을 수 있는 다리 중 가장 저렴한 다리
                Node cur = pq.poll();

                // 이미 방문한 섬이라면 스킵 (사이클 방지)
                if (visited[cur.to]) continue;

                // 섬 방문 처리 및 비용 추가
                visited[cur.to] = true;
                totalWeight += cur.weight;
                count++;

                // N개의 섬이 모두 연결되었다면 종료
                if (count == N) break;

                for (int i = 0; i < N; i++) {
                    if (!visited[i]) {
                        long distSq = (x[cur.to] - x[i]) * (x[cur.to] - x[i]) + (y[cur.to] - y[i]) * (y[cur.to] - y[i]);
                        pq.offer(new Node(i, distSq));
                    }
                }
            }

            long result = Math.round(E * totalWeight);

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}