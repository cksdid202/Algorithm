import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		//---------솔루션 코드를 작성하세요.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			
			for(int i=0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			int cnt = 0;
			
			for(int i = 0; i < N; i++) { // 가로 체크
				
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1) { // 1일때
						int length = 1;
						int tmp = 1;
						
						while(j+tmp < N) { // isIn
							if(map[i][j+tmp] == 1) { // 늘려가며 1이면 ++
								length++;
							}
							else { // 0이면 끊긴거라 break;
								break;
							}
							tmp++; //
						}
						if(length == K) {
							cnt++;
						}
						j = j+tmp; // 인덱스 갱신
					}
				}
			}
			
			for(int j = 0; j < N; j++) { // 세로 체크
				
				for(int i = 0; i < N; i++) {
					if(map[i][j] == 1) {
						int length = 1;
						int tmp = 1;
						while(i+tmp < N) {
							if(map[i+tmp][j] == 1) {
								length++;
							}
							else {
								break;
							}
							tmp++;
						}
						if(length == K) {
							cnt++;
						}
						i = i+tmp; // 인덱스 갱신
					}
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
		
		
		
		

	}

}
