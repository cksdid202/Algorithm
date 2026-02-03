
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine()); 
            int result = 1; 

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                st.nextToken(); 
                char data = st.nextToken().charAt(0); 

                // true면 자식이 있다는 뜻 (내부 노드)
                if (st.hasMoreTokens()) {
                    if (Character.isDigit(data)) {
                        result = 0;
                    }
                } else {
                    
                    if (!Character.isDigit(data)) {
                        result = 0;
                    }
                }
            }
         

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        
        System.out.println(sb);
    }
}