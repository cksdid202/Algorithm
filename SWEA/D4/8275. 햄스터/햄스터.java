import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int N; 
    static int X; 
    static int M; 
    
    static int[][] records; 
    static int[] cages;     
    static int[] bestCages;
    static int maxTotal;   

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            records = new int[M][3];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                records[i][0] = Integer.parseInt(st.nextToken()); // L
                records[i][1] = Integer.parseInt(st.nextToken()); // R
                records[i][2] = Integer.parseInt(st.nextToken()); // S
            }
            
            cages = new int[N + 1];
            bestCages = new int[N + 1];
            maxTotal = -1;
            
          
            dfs(1, 0);
            
            sb.append("#").append(t).append(" ");
            
            if (maxTotal == -1) {
                sb.append("-1\n");
            } else {
                for (int i = 1; i <= N; i++) {
                    sb.append(bestCages[i]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    static void dfs(int depth, int currentSum) {
        
        for (int i = 0; i < M; i++) {
            if (records[i][1] == depth - 1) { 
                int sum = 0;
                for (int j = records[i][0]; j <= records[i][1]; j++) { 
                    sum += cages[j];
                }
                
                if (sum != records[i][2]) {
                    return; 
                }
            }
        }

        if (depth == N + 1) {
            if (currentSum > maxTotal) {
                maxTotal = currentSum;
                for (int i = 1; i <= N; i++) {
                    bestCages[i] = cages[i]; 
                }
            }
            return;
        }

        for (int i = 0; i <= X; i++) {
            cages[depth] = i;
            dfs(depth + 1, currentSum + i);
        }
    }
}