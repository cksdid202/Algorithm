import java.util.*;
import java.io.*;

public class Main {
    static int[][] map = new int[5][5];
    static int bingoCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int callCount = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                callCount++;
                int num = Integer.parseInt(st.nextToken());
                
                markNumber(num);
                
                if (callCount >= 12) {
                    if (checkBingo() >= 3) {
                        System.out.println(callCount);
                        return; 
                    }
                }
            }
        }
    }

    public static void markNumber(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == num) {
                    map[i][j] = 0;
                    return;
                }
            }
        }
    }

    public static int checkBingo() {
        int lines = 0;

        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 0) count++;
            }
            if (count == 5) lines++;
        }

        for (int j = 0; j < 5; j++) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (map[i][j] == 0) count++;
            }
            if (count == 5) lines++;
        }

        int diagonal1 = 0;
        for (int i = 0; i < 5; i++) {
            if (map[i][i] == 0) diagonal1++;
        }
        if (diagonal1 == 5) lines++;

        int diagonal2 = 0;
        for (int i = 0; i < 5; i++) {
            if (map[i][4 - i] == 0) diagonal2++;
        }
        if (diagonal2 == 5) lines++;

        return lines;
    }
}