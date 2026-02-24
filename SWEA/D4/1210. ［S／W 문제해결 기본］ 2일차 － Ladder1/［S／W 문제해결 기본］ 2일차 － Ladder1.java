import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 10; t++) {
            int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
            int[][] map = new int[100][100];
            
            // 도착점의 좌표를 저장할 변수
            int r = 0, c = 0;

            // 맵 입력 받기
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    // 도착점(2) 찾기
                    if (map[i][j] == 2) {
                        r = i;
                        c = j;
                    }
                }
            }

            while (r > 0) {
                map[r][c] = 0; // 

                if (c - 1 >= 0 && map[r][c - 1] == 1) {
                    c--;
                }
                else if (c + 1 < 100 && map[r][c + 1] == 1) {
                    c++;
                }
                else {
                    r--;
                }
            }

            sb.append("#").append(tc).append(" ").append(c).append("\n");
        }
        System.out.print(sb);
    }
}
