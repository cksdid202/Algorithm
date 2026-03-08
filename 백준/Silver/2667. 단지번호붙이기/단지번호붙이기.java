import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int count; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0; 
                    dfs(i, j); 
                    result.add(count); // 탐색이 끝나면 모인 집의 수를 리스트에 저장
                }
            }
        }
        
        Collections.sort(result); // 오름차순
        
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n"); 
        for (int size : result) {
            sb.append(size).append("\n"); 
        }
        System.out.print(sb);
    }
    
    static void dfs(int r, int c) {
        visited[r][c] = true;
        count++; 
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (map[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }
}