
import java.io.*;
import java.util.*;

public class Solution {
    
    static int N, M;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // 큐에 넣을 좌표와 현재까지 걸린 시간
    static class Point {
        int r, c, time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            map = new char[N][M];
            Queue<Point> devilQ = new ArrayDeque<>();
            Queue<Point> suyeonQ = new ArrayDeque<>();
            
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j);
                    
                    // 악마의 위치와 수연이의 위치를 각각의 큐
                    if (map[i][j] == '*') {
                        devilQ.offer(new Point(i, j, 0));
                    } else if (map[i][j] == 'S') {
                        suyeonQ.offer(new Point(i, j, 0));
                    }
                }
            }
            
            int result = bfs(devilQ, suyeonQ);
            
            sb.append("#").append(t).append(" ");
            if (result == -1) {
                sb.append("GAME OVER\n"); 
            } else {
                sb.append(result).append("\n"); 
            }
        }
        System.out.print(sb);
    }

    static int bfs(Queue<Point> devilQ, Queue<Point> suyeonQ) {
        
        // 수연이가 더 이상 갈 곳이 없을 때까지 반복
        while (!suyeonQ.isEmpty()) {
            
            // 악마의 스킬 1초 확산
            // 현재 큐에 들어있는 악마의 개수만큼만 반복해야 딱 '1초'가 흐른 것
            int devilSize = devilQ.size();
            for (int i = 0; i < devilSize; i++) {
                Point cur = devilQ.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        // 악마는 평지(.)나 수연이가 있는 곳(S)으로만 퍼질 수 있 
                        // (여신님 D나 돌 X로는 못 감)
                        if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
                            map[nr][nc] = '*'; // 지도를 악마 스킬로 오염시킴
                            devilQ.offer(new Point(nr, nc, 0));
                        }
                    }
                }
            }
            
            // 수연이 1초 이동
            // 역시 현재 큐에 있는 수연이의 갈래 개수만큼만 반복해야 1초치 이동입니다.
            int suyeonSize = suyeonQ.size();
            for (int i = 0; i < suyeonSize; i++) {
                Point cur = suyeonQ.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        // 여신님을 만났다면 즉시 현재 시간 + 1 반환
                        if (map[nr][nc] == 'D') {
                            return cur.time + 1;
                        }
                        
                        // 평지라면 이동 (악마가 오염시킨 곳은 못 감)
                        if (map[nr][nc] == '.') {
                            map[nr][nc] = 'S'; // 방문 흔적 남기기 (다시 안 돌아가게 방지)
                            suyeonQ.offer(new Point(nr, nc, cur.time + 1));
                        }
                    }
                }
            }
        }
        
        // 큐가 다 비었는데도 여신님을 못 만났다면 갈 수 없는 길
        return -1;
    }
}
