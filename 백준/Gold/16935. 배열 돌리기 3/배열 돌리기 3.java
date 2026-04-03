import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int op = Integer.parseInt(st.nextToken());
            operation(op);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void operation(int op) {
        switch (op) {
            case 1: op1(); break; 
            case 2: op2(); break; 
            case 3: op3(); break; 
            case 4: op4(); break; 
            case 5: op5(); break; 
            case 6: op6(); break; 
        }
    }

    static void op1() {
        int[][] next = new int[N][M];
        for (int i = 0; i < N; i++) {
            next[N - 1 - i] = map[i]; 
        }
        map = next;
    }

    static void op2() {
        int[][] next = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                next[i][M - 1 - j] = map[i][j];
            }
        }
        map = next;
    }

    static void op3() {
        int[][] next = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                next[j][N - 1 - i] = map[i][j];
            }
        }
        int temp = N;
        N = M;
        M = temp;
        map = next;
    }

    static void op4() {
        int[][] next = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                next[M - 1 - j][i] = map[i][j];
            }
        }
        int temp = N;
        N = M;
        M = temp;
        map = next;
    }

    static void op5() {
        int[][] next = new int[N][M];
        int rMid = N / 2;
        int cMid = M / 2;

        for (int i = 0; i < rMid; i++) {
            for (int j = 0; j < cMid; j++) {
                next[i][j + cMid] = map[i][j]; // 1 -> 2
                next[i + rMid][j + cMid] = map[i][j + cMid]; // 2 -> 3
                next[i + rMid][j] = map[i + rMid][j + cMid]; // 3 -> 4
                next[i][j] = map[i + rMid][j]; // 4 -> 1
            }
        }
        map = next;
    }

    static void op6() {
        int[][] next = new int[N][M];
        int rMid = N / 2;
        int cMid = M / 2;

        for (int i = 0; i < rMid; i++) {
            for (int j = 0; j < cMid; j++) {
                next[i + rMid][j] = map[i][j]; // 1 -> 4
                next[i + rMid][j + cMid] = map[i + rMid][j]; // 4 -> 3
                next[i][j + cMid] = map[i + rMid][j + cMid]; // 3 -> 2
                next[i][j] = map[i][j + cMid]; // 2 -> 1
            }
        }
        map = next;
    }
}