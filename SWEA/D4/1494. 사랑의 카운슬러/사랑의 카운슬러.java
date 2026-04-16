import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static long minAns;
    static Point[] points;
    static long totalX, totalY;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            points = new Point[N];
            totalX = 0;
            totalY = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
                totalX += x;
                totalY += y;
            }

            minAns = Long.MAX_VALUE;
            // 0번 지렁이는 무조건 '더하기' 팀에 고정 (중복 계산 방지)
            dfs(1, 1, points[0].x, points[0].y);

            System.out.println("#" + t + " " + minAns);
        }
    }


    static void dfs(int idx, int count, long sumX, long sumY) {
        if (count == N / 2) {
            long vx = 2 * sumX - totalX;
            long vy = 2 * sumY - totalY;
            long res = vx * vx + vy * vy;
            
            if (res < minAns) minAns = res;
            return;
        }

        if (idx == N) return;

        dfs(idx + 1, count + 1, sumX + points[idx].x, sumY + points[idx].y);

        dfs(idx + 1, count, sumX, sumY);
    }
}