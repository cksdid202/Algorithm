
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] gyuCards; 
    static int[] inCards;  
    static int[] resultIn; // 인영이가 내는 순서 (순열 완성본)
    static boolean[] visited; // 순열용 방문 체크
    static int winCount, loseCount; // 규영이의 승/패 횟수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            gyuCards = new int[9];
            inCards = new int[9];
            resultIn = new int[9];
            visited = new boolean[9];
            winCount = 0;
            loseCount = 0;

            // 규영이 카드인지 체크
            boolean[] isGyuCard = new boolean[19];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                gyuCards[i] = Integer.parseInt(st.nextToken());
                isGyuCard[gyuCards[i]] = true;
            }

            // 규영이 거 빼고 나머지
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!isGyuCard[i]) {
                    inCards[idx++] = i;
                }
            }

            perm(0);

            sb.append("#").append(t).append(" ")
              .append(winCount).append(" ").append(loseCount).append("\n");
        }
        System.out.print(sb);
    }

    // 순열 생성 
    public static void perm(int depth) {
        if (depth == 9) {
            playGame();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                resultIn[depth] = inCards[i]; 
                perm(depth + 1);
                visited[i] = false; // 
            }
        }
    }

    // 게임 승부 계산 로직
    public static void playGame() {
        int gyuScore = 0;
        int inScore = 0;

        for (int i = 0; i < 9; i++) {
            if (gyuCards[i] > resultIn[i]) {
                gyuScore += gyuCards[i] + resultIn[i];
            } else {
                inScore += gyuCards[i] + resultIn[i];
            }
        }

        if (gyuScore > inScore) winCount++;
        else if (gyuScore < inScore) loseCount++;
    }
}
