import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            long N = Long.parseLong(br.readLine()); // N이 10^18이므로 long 필수
            long count = 0;

            // N이 2가 될 때까지 반복
            while (N > 2) {
                // 현재 N의 정수 제곱근을 구함
                long root = (long) Math.sqrt(N);

                if (root * root == N) {
                    // 1. N이 완전 제곱수인 경우 -> 바로 제곱근을 취함
                    N = root;
                    count++;
                } else {
                    // 2. N이 완전 제곱수가 아닌 경우
                    // 가장 가까운 '다음 제곱수'로 만들기 위해 +1 연산을 한 번에 계산
                    long nextRoot = root + 1;
                    long target = nextRoot * nextRoot; // 목표하는 다음 제곱수
                    
                    // (목표값 - 현재값) 만큼 +1 연산을 수행해야 함
                    count += (target - N);
                    
                    // 그 다음 바로 제곱근 연산을 수행했다고 가정하고 N과 count 갱신
                    count++; 
                    N = nextRoot; 
                }
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        
        System.out.print(sb);
    }
}