import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static int[][] map;
    static int count = 0; 
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); 
        int c = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken()); 
        
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        clean(r, c, d);
        
        System.out.println(count);
    }
    
    public static void clean(int r, int c, int dir) {
        
        if (map[r][c] == 0) {
            map[r][c] = 2; 
            count++;
        }
        
        boolean hasUncleaned = false;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (map[nr][nc] == 0) {
                    hasUncleaned = true;
                    break;
                }
            }
        }
        
        if (hasUncleaned) {
            
            int nd = (dir + 3) % 4; 
            int nr = r + dr[nd];
            int nc = c + dc[nd];
            
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                clean(nr, nc, nd); 
            } else {
                clean(r, c, nd); 
            }
            
        } else {
            
            int backDir = (dir + 2) % 4;
            int nr = r + dr[backDir];
            int nc = c + dc[backDir];
            
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {
                clean(nr, nc, dir); 
            } else {
                return;
            }
        }
    }
}