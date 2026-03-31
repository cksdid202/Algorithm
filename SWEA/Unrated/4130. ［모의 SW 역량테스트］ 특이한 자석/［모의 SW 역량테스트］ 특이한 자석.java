import java.util.*;
import java.io.*;

public class Solution {
    static int[][] magnets;
    static int[] rotation;  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine()); 
            magnets = new int[4][8];

            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnets[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1; 
                int dir = Integer.parseInt(st.nextToken());   

                rotation = new int[4];
                checkRotation(idx, dir);

                for (int j = 0; j < 4; j++) {
                    if (rotation[j] != 0) {
                        rotate(j, rotation[j]);
                    }
                }
            }

            int score = 0;
            if (magnets[0][0] == 1) score += 1;
            if (magnets[1][0] == 1) score += 2;
            if (magnets[2][0] == 1) score += 4;
            if (magnets[3][0] == 1) score += 8;

            System.out.println("#" + t + " " + score);
        }
    }

    static void checkRotation(int idx, int dir) {
        rotation[idx] = dir;

        for (int i = idx; i < 3; i++) {
            if (magnets[i][2] != magnets[i + 1][6]) {
                rotation[i + 1] = -rotation[i];
            } else {
                break; 
            }
        }

        for (int i = idx; i > 0; i--) {
            if (magnets[i][6] != magnets[i - 1][2]) {
                rotation[i - 1] = -rotation[i];
            } else {
                break;
            }
        }
    }

    static void rotate(int idx, int dir) {
        if (dir == 1) { 
            int temp = magnets[idx][7];
            for (int i = 7; i > 0; i--) {
                magnets[idx][i] = magnets[idx][i - 1];
            }
            magnets[idx][0] = temp;
        } else { 
            int temp = magnets[idx][0];
            for (int i = 0; i < 7; i++) {
                magnets[idx][i] = magnets[idx][i + 1];
            }
            magnets[idx][7] = temp;
        }
    }
}