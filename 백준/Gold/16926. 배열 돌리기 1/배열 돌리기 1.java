
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < R; i++) {
			rotate();
		}
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
		
		

	}
	
	static void rotate() {
		
		int layers = Math.min(N, M) / 2;
		
		for(int i = 0; i < layers; i++) {
			int x1 = i;
			int y1 = i;
			int x2 = N - 1 - i;
			int y2 = M - 1 - i;
			
			int temp = arr[x1][y1];
			
			// 위
			for(int j = y1; j < y2; j++) {
				arr[x1][j] = arr[x1][j+1];
			}
			// 오른변
			for(int j = x1; j < x2; j++) {
				arr[j][y2] = arr[j+1][y2];
			}
			// 아래
			for(int j = y2; j > y1; j--) {
				arr[x2][j] = arr[x2][j-1];
			}
			// 왼변
			for(int j = x2; j > x1; j--) {
				arr[j][y1] = arr[j-1][y1];
			}
			
			arr[x1+1][y1] = temp;
			
			
			
			
		}
		
		
	}
	

}
