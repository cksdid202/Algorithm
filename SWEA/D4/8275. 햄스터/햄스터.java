import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int N, X, M;
    static int[] cages;      // 햄스터 배치 상태
    static int[] answer;     // 최적 배치
    static int[][] records;  // 경근이의 기록 (l, r, s)
    static int maxHamster;   // 최대 햄스터 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 우리 개수
            X = Integer.parseInt(st.nextToken()); // 각 우리 최대 햄스터 수
            M = Integer.parseInt(st.nextToken()); // 기록 수

            cages = new int[N + 1]; // 1번 인덱스부터 사용
            answer = new int[N + 1];
            records = new int[M][3];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                records[i][0] = Integer.parseInt(st.nextToken()); // l
                records[i][1] = Integer.parseInt(st.nextToken()); // r
                records[i][2] = Integer.parseInt(st.nextToken()); // s
            }

            maxHamster = -1; // 초기값 -1 (못 찾는 경우)

            //  1번 우리부터
            dfs(1, 0);

            sb.append("#").append(t).append(" ");
            
            if (maxHamster == -1) {
                sb.append("-1");
            } else {
                for (int i = 1; i <= N; i++) {
                    sb.append(answer[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }

    // cnt: 현재 채우고 있는 우리 번호, currentSum: 현재까지의 햄스터 합
    public static void dfs(int cnt, int currentSum) {
        
        // N개의 우리를 모두 채웠을 때
        if (cnt == N + 1) {
            
            // 기록된 M개의 조건(records)을 모두 만족하는지 검사
            if (check()) {
                // 조건 만족 시, 합이 최대인지 확인
                // > 를 사용 -> 합이 같을 때 갱신하지 않아 자연스럽게 사전 순
                if (currentSum > maxHamster) {
                    maxHamster = currentSum;
                    // 정답 배열 복사
                    for (int i = 1; i <= N; i++) {
                        answer[i] = cages[i];
                    }
                }
            }
            return;
        }

        // (재귀) 0마리부터 X마리까지 넣어봄 (중복 순열)
        // 0부터 넣어야 '사전 순으로 빠른' 해를 먼저 찾게 됨
        for (int i = 0; i <= X; i++) {
            cages[cnt] = i;
            dfs(cnt + 1, currentSum + i);
        }
    }

    // 조건 검사 
    public static boolean check() {
        for (int i = 0; i < M; i++) {
            int l = records[i][0];
            int r = records[i][1];
            int s = records[i][2];

            int sum = 0;
            for (int j = l; j <= r; j++) {
                sum += cages[j];
            }

            // 기록과 다르면 실패
            if (sum != s) {
                return false;
            }
        }
        return true;
    }
}