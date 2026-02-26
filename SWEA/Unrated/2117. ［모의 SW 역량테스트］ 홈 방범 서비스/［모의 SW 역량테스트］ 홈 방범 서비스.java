
import java.util.*;
import java.io.*;

public class Solution {

	static int N, M;
	static int[][] map;
	static ArrayList<int[]> houses;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			houses = new ArrayList<>();

			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {

					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						houses.add(new int[] { i, j });
					}

				}

			}

			int maxHouses = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					int[] distCount = new int[2 * N];

					for (int[] house : houses) {
						int dist = Math.abs(r - house[0]) + Math.abs(c - house[1]);
						distCount[dist]++;
					}

					int currentHouses = 0;
					for (int K = 1; K <= N + 1; K++) {
						currentHouses += distCount[K - 1];

						int cost = K * K + (K - 1) * (K - 1);
						int income = currentHouses * M;

						if (income >= cost) {
							maxHouses = Math.max(maxHouses, currentHouses);
						}
					}

				}
			}

			System.out.println("#" + t + " " + maxHouses);

		}

	}

}
