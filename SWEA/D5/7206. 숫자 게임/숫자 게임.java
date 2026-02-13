import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    // N이 최대 99999이므로 10만 크기의 배열로 메모이제이션
    static int[] memo = new int[100000];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            
            // 계산 시작
            int result = solve(N);
            
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        
        System.out.print(sb);
    }

    // 현재 숫자 n에서 가능한 최대 턴 수를 반환하는 함수 (DFS)
    static int solve(int n) {
        // [기저 조건] 한 자리 수가 되면 게임 종료 (턴 수 0)
        if (n < 10) {
            return 0;
        }

        // [메모이제이션] 이미 계산한 적 있다면 저장된 값 반환
        if (memo[n] != 0) {
            return memo[n];
        }

        String s = String.valueOf(n);
        int len = s.length();
        int maxTurn = 0;

        // [완전 탐색] 비트마스크를 이용해 자를 수 있는 모든 위치 조합 시도
        // 길이 L 문자열에는 (L-1)개의 자를 수 있는 틈이 있음.
        // 예: "123" (len=3) -> 틈 2개 -> 비트 00(X), 01, 10, 11 가능
        for (int i = 1; i < (1 << (len - 1)); i++) {
            int currentProd = 1;        // 현재 조합의 곱
            int currentNum = s.charAt(0) - '0'; // 현재 만들고 있는 부분 숫자

            for (int j = 0; j < len - 1; j++) {
                // j번째 비트가 1이면: j번째 숫자 뒤에서 자른다는 의미
                if ((i & (1 << j)) != 0) {
                    currentProd *= currentNum;
                    currentNum = 0; // 다음 부분 숫자를 위해 초기화
                }
                
                // 다음 자릿수 이어 붙이기
                currentNum = currentNum * 10 + (s.charAt(j + 1) - '0');
            }
            // 마지막 남은 부분 숫자 곱하기
            currentProd *= currentNum;

            // 재귀 호출로 다음 단계의 최대 턴 수 구하기
            int turn = solve(currentProd);
            
            // 최댓값 갱신
            maxTurn = Math.max(maxTurn, turn);
        }

        // 현재 턴(1) + 다음 단계에서 가능한 최대 턴 수 저장
        return memo[n] = maxTurn + 1;
    }
}