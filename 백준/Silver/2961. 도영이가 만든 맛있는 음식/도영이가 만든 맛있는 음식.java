import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] ingredients; 
    static int minDiff = Integer.MAX_VALUE; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        ingredients = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken()); 
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }
        
        subset(0, 1, 0, 0);
        
        System.out.println(minDiff);
    }
    
    // depth: 현재 살펴보고 있는 재료의 인덱스
    // sour: 현재까지 고른 재료들의 신맛 곱
    // bitter: 현재까지 고른 재료들의 쓴맛 합
    // count: 현재까지 고른 재료의 총 개수
    static void subset(int depth, int sour, int bitter, int count) {
        
        // [기저 조건] N개의 재료에 대해 모두 판단이 끝났다면
        if (depth == N) {
            // (공집합 제외)
            if (count > 0) {
                // 최솟값 갱신
                int diff = Math.abs(sour - bitter);
                minDiff = Math.min(minDiff, diff);
            }
            return;
        }
        
        // 요리에 넣는 경우
        subset(depth + 1, sour * ingredients[depth][0], bitter + ingredients[depth][1], count + 1);
        
        // 요리에 넣지 않는 경우
        subset(depth + 1, sour, bitter, count);
    }
}