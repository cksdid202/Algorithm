import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int[] T; 
    static int[] P; 
    static int maxProfit = 0; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        
        System.out.println(maxProfit);
    }
    
    static void dfs(int day, int profit) {
        
        if (day == N) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }
        
        if (day > N) {
            return;
        }
        
       
        
        // 상담 O
        dfs(day + T[day], profit + P[day]);
        
        // 상담 X
        dfs(day + 1, profit);
    }
}