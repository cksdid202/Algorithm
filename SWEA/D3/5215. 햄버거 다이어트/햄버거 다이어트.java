
import java.io.*;
import java.util.*;

public class Solution {
    
    static int N, L; 
    static int[] tastes; // 맛 점수
    static int[] calories; // 칼로리 배열
    static int maxScore; // 최대 점수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            tastes = new int[N];
            calories = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                tastes[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }

            maxScore = 0; // 초기화
            
            // 재귀
            subset(0, 0, 0);

            sb.append("#").append(t).append(" ").append(maxScore).append("\n");
        }
        
        System.out.print(sb);
    }

    
    public static void subset(int cnt, int sumTaste, int sumCal) {
        
        // 백트래킹? 칼로리 넘으면 볼 필요 X
        if (sumCal > L) {
            return;
        }

        // 종료 -> 모든 재료(N개)를 다 고려했을 때
        if (cnt == N) {
            if (sumTaste > maxScore) {
                maxScore = sumTaste;
            }
            return;
        }
        // 지금 재료 선택 할때.
        subset(cnt + 1, sumTaste + tastes[cnt], sumCal + calories[cnt]);
        // 지금 재료는 넘길 때.
        subset(cnt + 1, sumTaste, sumCal);
    }
}
