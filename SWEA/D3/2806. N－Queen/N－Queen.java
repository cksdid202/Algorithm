
import java.util.*;
import java.io.*;

public class Solution{
    
    static int N;
    static int[] board; // board[row] = col (각 행에 퀸이 놓인 열의 위치)
    static int count;   // 정답 (가능한 경우의 수)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            
            // 인덱스 = 행(Row), 값 = 열(Col)
            board = new int[N];
            count = 0;

            // 0번째 행부터 퀸 놓기 시작
            dfs(0);

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        
        System.out.print(sb);
    }

    // depth: 현재 퀸을 놓으려는 행(Row)
    public static void dfs(int depth) {
        // [기저 조건] N개의 퀸을 모두 놓았다면 성공
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i; // (depth, i)에 퀸 배치 시도

            // 유효성 검사
            if (isPromising(depth)) {
                dfs(depth + 1); // 다음 행으로 이동
            }
        }
    }

    // 유효성 검사
    public static boolean isPromising(int row) {
        // 현재 행 이전의 모든 행들과 비교
        for (int i = 0; i < row; i++) {
            
            // 같은 열 확인
            if (board[row] == board[i]) {
                return false;
            }

            // 대각선 확인
            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
}