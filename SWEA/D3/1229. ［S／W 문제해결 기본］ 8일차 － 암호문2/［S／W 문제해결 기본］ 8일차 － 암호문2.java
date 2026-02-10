
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            
            LinkedList<Integer> list = new LinkedList<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int cmdCount = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cmdCount; i++) {
                //while(!st.hasMoreTokens()) {
                //    st = new StringTokenizer(br.readLine());
                //}

                char cmd = st.nextToken().charAt(0); // I(삽입) 또는 D(삭제)
                int x = Integer.parseInt(st.nextToken()); // 위치 (인덱스)
                int y = Integer.parseInt(st.nextToken()); // 개수

                if (cmd == 'I') {
                    for (int k = 0; k < y; k++) {
                        int value = Integer.parseInt(st.nextToken());
                        list.add(x + k, value);
                    }
                } else if (cmd == 'D') {
                    
                    for (int k = 0; k < y; k++) {
                        list.remove(x);
                    }
                }
            }

            // 5. 결과 출력 (앞에서부터 10개만)
            sb.append("#").append(t);
            for (int i = 0; i < 10; i++) {
                sb.append(" ").append(list.get(i));
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
