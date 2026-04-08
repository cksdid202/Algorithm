import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); 
        int N = Integer.parseInt(st.nextToken()); 
        int[] cables = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            if (max < cables[i]) {
                max = cables[i];
            }
        }

       
        max++; 

        long low = 0;
        long high = max;
        long mid = 0;

        while (low < high) {
            mid = (low + high) / 2;
            
            long count = 0;
            
            for (int i = 0; i < K; i++) {
                count += (cables[i] / mid);
            }

            if (count < N) {
                high = mid;
            } 
            else {
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }
}