import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE; 
    static int V, E, K;
    static List<Node>[] adj; 
    static int[] dist;       

    static class Node implements Comparable<Node> {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // 가중치 오름차순
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); 
        E = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(br.readLine());    

        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF); 

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int now = curr.to;
            int weight = curr.weight;

            if (weight > dist[now]) continue;

            for (Node next : adj[now]) {
                if (dist[next.to] > dist[now] + next.weight) {
                    dist[next.to] = dist[now] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}