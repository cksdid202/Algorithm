import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            br.readLine(); 
            Queue<Integer> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            int value = 1; 
            
            while (true) {
                int num = queue.poll() - value;

                if (num <= 0) {
                    queue.offer(0);
                    break;
                }
                queue.offer(num);

                value++;
                if (value > 5) {
                    value = 1;
                }
            }

            sb.append("#").append(t);
            for (int num : queue) {
                sb.append(" ").append(num);
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}