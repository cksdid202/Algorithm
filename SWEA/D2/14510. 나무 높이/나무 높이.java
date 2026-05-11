import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] trees = new int[N];
            int maxH = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                if (trees[i] > maxH) maxH = trees[i];
            }

            int odd = 0;  // 1 자라야 하는 횟수
            int even = 0; // 2 자라야 하는 횟수

            for (int i = 0; i < N; i++) {
                int diff = maxH - trees[i];
                if (diff == 0) continue;

                even += diff / 2;
                odd += diff % 2;
            }

            // 2를 1+1로 변환하여 밸런스를 맞춤
            // 짝수 날(2)이 너무 많으면 효율이 떨어지므로 홀수 날(1)로 쪼개기
            while (even > odd + 1) {
                even--;
                odd += 2;
            }

            int result = 0;
            if (odd == even) {
                result = even * 2;
            } else if (odd > even) {
                result = odd * 2 - 1;
            } else { // even > odd 인 경우 (위의 while문에 의해 차이는 1뿐임)
                result = even * 2;
            }

            System.out.println("#" + t + " " + result);
        }
    }
}