
import java.util.*;
import java.io.*;

public class Solution{
	
	static int K;
	static int[][] magnet = new int[5][8];
	static int[][] spin;
	static int[] rotation;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			K = Integer.parseInt(br.readLine());
			for(int i = 1; i <= 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			spin = new int[K][2];
			for(int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				spin[i][0] = Integer.parseInt(st.nextToken());
				spin[i][1] = Integer.parseInt(st.nextToken());
				
			}
			for(int i = 0; i < K; i++) {
				rotation = new int[5];
				Sspin(spin[i][0], spin[i][1]);
				
				for(int j = 1; j < 5; j++) {
					realSpin(j, rotation[j]);
				}
				
			}
			int cnt = 0;
			if(magnet[1][0] == 1) {
				cnt += 1;
			}
			if(magnet[2][0] == 1) {
				cnt += 2;
			}
			if(magnet[3][0] == 1) {
				cnt += 4;
			}
			if(magnet[4][0] == 1) {
				cnt += 8;
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
			
			
			
		}
		System.out.print(sb);
		
		
		
		
		
		
	}
	
	public static void Sspin(int num, int dir) {
		
		rotation[num] = dir;
		
		// 오른쪽
		for(int i = num; i < 4; i++) {
			if(magnet[i][2] != magnet[i+1][6]) {
				rotation[i+1] = -rotation[i];
			}
			else {
				break;
			}
		}
		// 왼쪽
		for(int i = num; i > 1; i--) {
			if(magnet[i][6] != magnet[i-1][2]) {
				rotation[i-1] = -rotation[i];
			}
			else {
				break;
			}
		}
		
		
	}
	
	public static void realSpin(int num, int dir) {
		
		if(dir == 0) return;
		
		if(dir == 1) {
			int tmp = magnet[num][7];
			for(int i=6; i>=0; i--) {
				magnet[num][i+1] = magnet[num][i];
			}
			magnet[num][0] = tmp;
		}
		else {
			int tmp = magnet[num][0];
			for(int i=1; i<=7; i++) {
				magnet[num][i-1] = magnet[num][i];
			}
			magnet[num][7] = tmp;
		}
		
	}
	
	

}
