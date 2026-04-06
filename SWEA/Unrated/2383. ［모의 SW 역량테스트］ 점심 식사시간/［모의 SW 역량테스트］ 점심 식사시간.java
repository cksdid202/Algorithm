import java.util.*;
import java.io.*;

public class Solution {
    static class Person {
        int r, c, dist;
        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Stair {
        int r, c, k;
        public Stair(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }

    static int N, minTime;
    static List<Person> people;
    static Stair[] stairs;
    static int[] selectedStair;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            people = new ArrayList<>();
            stairs = new Stair[2];
            int stairIdx = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (val == 1) people.add(new Person(i, j));
                    else if (val > 1) stairs[stairIdx++] = new Stair(i, j, val);
                }
            }

            selectedStair = new int[people.size()];
            minTime = Integer.MAX_VALUE;
            
            divide(0); 

            System.out.println("#" + t + " " + minTime);
        }
    }

    static void divide(int idx) {
        if (idx == people.size()) {
            simulate();
            return;
        }

        selectedStair[idx] = 0;
        divide(idx + 1);

        selectedStair[idx] = 1;
        divide(idx + 1);
    }

    static void simulate() {
        int totalMaxTime = 0;

        for (int s = 0; s < 2; s++) {
            List<Integer> arrivalTimes = new ArrayList<>();
            for (int i = 0; i < people.size(); i++) {
                if (selectedStair[i] == s) {
                    int d = Math.abs(people.get(i).r - stairs[s].r) + Math.abs(people.get(i).c - stairs[s].c);
                    arrivalTimes.add(d);
                }
            }

            if (arrivalTimes.isEmpty()) continue;

            Collections.sort(arrivalTimes);

            int stairTime = calculateStairTime(arrivalTimes, stairs[s].k);
            totalMaxTime = Math.max(totalMaxTime, stairTime);
        }

        minTime = Math.min(minTime, totalMaxTime);
    }

    static int calculateStairTime(List<Integer> arrivals, int K) {
        int[] finishTime = new int[arrivals.size()];

        for (int i = 0; i < arrivals.size(); i++) {
            int arrival = arrivals.get(i);
            
            if (i < 3) {
                finishTime[i] = arrival + 1 + K;
            } else {
                int enterTime = Math.max(arrival + 1, finishTime[i - 3]);
                finishTime[i] = enterTime + K;
            }
        }

        return finishTime[arrivals.size() - 1];
    }
}