
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[][] paper = new boolean[100][100];
        
        int N = Integer.parseInt(br.readLine());
        int totalArea = 0; 
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); 
            int y = Integer.parseInt(st.nextToken()); 

            for (int r = x; r < x + 10; r++) {
                for (int c = y; c < y + 10; c++) {
                    
                    // 아직 색종이가 안 붙은 곳만 카운트
                    if (!paper[r][c]) {
                        paper[r][c] = true; 
                        totalArea++;        
                    }
                }
            }
        }

        System.out.println(totalArea);
    }
}
