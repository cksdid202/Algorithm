
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, B; // N: 점원 수, B: 선반 높이
    static int[] heights; // 키 
    static int minDiff; // B 이상인 탑 중에서 가장 작은 차이 (정답)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); 

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            heights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            minDiff = Integer.MAX_VALUE;

            dfs(0, 0);

            sb.append("#").append(t).append(" ").append(minDiff).append("\n");
        }
        System.out.print(sb);
    }

    
    public static void dfs(int cnt, int sum) { // 고려 점원 수, 현재 탑 높이
        // [가지치기] 현재 합이 B 이상이라면, 정답 갱신 시도
        if (sum >= B) {
            minDiff = Math.min(minDiff, sum - B);
            // 만약 차이가 0이라면 더 이상 줄일 수 없으므로 종료 가능 
            return;
        }

        // [기저 조건] 모든 점원을 다 고려했을 때
        if (cnt == N) {
            return;
        }

        // 현재 점원을 탑에 포함하는 경우
        dfs(cnt + 1, sum + heights[cnt]);

        // 현재 점원을 탑에 포함하지 않는 경우
        dfs(cnt + 1, sum);
    }
}
