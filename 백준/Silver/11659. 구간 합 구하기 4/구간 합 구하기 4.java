

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] S = new int[N+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= N; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	
        	S[i] = S[i-1] + num;
        }
        
        for(int k = 0; k < M; k++) {
        	st = new StringTokenizer(br.readLine());
        	int i = Integer.parseInt(st.nextToken());
        	int j = Integer.parseInt(st.nextToken());
        	
        	int result = S[j] - S[i-1];
        	
        	sb.append(result).append("\n");
        }
        
        System.out.print(sb);
        
    }
}
