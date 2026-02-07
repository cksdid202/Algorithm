import java.io.*;
import java.util.*;

public class Solution {
    
    static int N, M;
    static boolean[][] badPair; 
    static boolean[] isSelected; 
    static int count; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); 
            M = Integer.parseInt(st.nextToken()); 

            badPair = new boolean[N + 1][N + 1];
            isSelected = new boolean[N + 1];

            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                
                badPair[a][b] = true;
                badPair[b][a] = true;
            }

            count = 0;
            
            // 부분집합 재귀 호출 1번 재료부터
            subset(1);

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        
        System.out.println(sb);
    }

    public static void subset(int idx) {
        
        if (idx == N + 1) {
            count++; // 여기까지 왔다면 유효한 버거
            return;
        }

        // 현재 재료(idx)를 선택하지 않는 경우 가능
        subset(idx + 1);

        // 2. 현재 재료(idx)를 선택하려는 경우
        // 기존에 선택된 재료들과 궁합이 안 맞는게 있는지 확인
        boolean isPossible = true;
        for (int i = 1; i < idx; i++) {
            // (badPair)
            if (isSelected[i] && badPair[i][idx]) {
                isPossible = false;
                break;
            }
        }

        // 궁합 문제가 없을 때만 선택하고 넘어감
        if (isPossible) {
            isSelected[idx] = true; // 선택 처리
            subset(idx + 1);        // 다음 재료로
            isSelected[idx] = false; // 백트래킹
        }
    }
}