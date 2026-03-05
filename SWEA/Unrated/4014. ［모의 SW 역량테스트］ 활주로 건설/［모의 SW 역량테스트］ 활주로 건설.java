import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, X;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 맵 크기
            X = Integer.parseInt(st.nextToken()); // 경사로의 길이

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0; // 건설 가능한 활주로 개수

            for (int i = 0; i < N; i++) {
                if (canBuild(i, 0, 0, 1)) ans++; // i번째 가로줄(행) 검사
                if (canBuild(0, i, 1, 0)) ans++; // i번째 세로줄(열) 검사
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    // 2. 뽑아낸 1차원 길에 활주로를 건설 판별
    static boolean canBuild(int startR, int startC, int dr, int dc) {
        int[] line = new int[N];
        
        for (int i = 0; i < N; i++) {
            line[i] = map[startR + dr * i][startC + dc * i];
        }

        boolean[] slope = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = line[i] - line[i + 1]; // 현재 칸과 다음 칸의 높이 차이

            if (diff == 0) continue; // 평지면 그냥 지나감

            if (diff == -1) {
                for (int j = 0; j < X; j++) {
                    int past = i - j;
                    if (past < 0 || line[past] != line[i] || slope[past]) {
                        return false; 
                    }
                    slope[past] = true; 
                }
            } 
            else if (diff == 1) {
                for (int j = 1; j <= X; j++) {
                    int future = i + j;
                    // 범위를 벗어나거나, 높이가 다르거나, 이미 경사로가 놓여있다면 실패
                    if (future >= N || line[future] != line[i + 1] || slope[future]) {
                        return false; 
                    }
                    slope[future] = true; 
                }
            } 
            // 높이 차이가 2 이상 나면 X
            else {
                return false;
            }
        }
        
        // 끝까지 통과했다면 건설 가능
        return true; 
    }
}