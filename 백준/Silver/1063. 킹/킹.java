import java.util.*;
import java.io.*;

public class Main {
    // 8방향 문제 순서
    // R, L, B, T, RT, LT, RB, LB
    static int[] dr = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
    static String[] commands = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String kingPos = st.nextToken();
        String stonePos = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int[] king = {kingPos.charAt(1) - '1', kingPos.charAt(0) - 'A'};
        int[] stone = {stonePos.charAt(1) - '1', stonePos.charAt(0) - 'A'};

        for (int i = 0; i < N; i++) {
            String move = br.readLine();
            int d = -1;
            
            for (int j = 0; j < 8; j++) {
                if (commands[j].equals(move)) {
                    d = j;
                    break;
                }
            }

            int nkr = king[0] + dr[d];
            int nkc = king[1] + dc[d];

            if (nkr >= 0 && nkr < 8 && nkc >= 0 && nkc < 8) {
                if (nkr == stone[0] && nkc == stone[1]) {
                    int nsr = stone[0] + dr[d];
                    int nsc = stone[1] + dc[d];

                    if (nsr >= 0 && nsr < 8 && nsc >= 0 && nsc < 8) {
                        king[0] = nkr;
                        king[1] = nkc;
                        stone[0] = nsr;
                        stone[1] = nsc;
                    }
                } else {
                    king[0] = nkr;
                    king[1] = nkc;
                }
            }
        }

        System.out.println((char)(king[1] + 'A') + "" + (char)(king[0] + '1'));
        System.out.println((char)(stone[1] + 'A') + "" + (char)(stone[0] + '1'));
    }
}