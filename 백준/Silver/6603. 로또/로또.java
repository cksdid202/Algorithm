import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int K;
    static int[] arr;       
    static int[] result;    
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            K = Integer.parseInt(st.nextToken());
            
            if (K == 0) {
                break;
            }
            
            arr = new int[K];
            result = new int[6]; 
            
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            combination(0, 0);
            
            sb.append("\n"); 
        }
        
        System.out.print(sb);
    }
    
    static void combination(int depth, int start) {
        
        if (depth == 6) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i < K; i++) {
            
            result[depth] = arr[i]; 
            
            combination(depth + 1, i + 1); 
        }
    }
}