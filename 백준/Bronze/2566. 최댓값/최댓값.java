import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = -1; 
        int row = 0;
        int col = 0;

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int current = Integer.parseInt(st.nextToken());

                if (current > max) {
                    max = current;
                    row = i; 
                    col = j; 
                }
            }
        }

        System.out.println(max);
        System.out.println(row + " " + col);
    }
}