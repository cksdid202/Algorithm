import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		
		for(int t=0; t<T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int currentH = 0;
			int currentW = 0;
			char map[][] = new char[H][W];
			for(int i=0; i<H; i++) {
				String line = br.readLine();
				for(int j=0; j<W; j++) {	
					map[i][j] = line.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						currentH = i;
						currentW = j;
					}
				}
				
			}
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			
			for(int i=0; i<N; i++) {
				
				switch(line.charAt(i)) {
				case 'U' :
					map[currentH][currentW] = '^';
					if(currentH-1 >= 0) {
						if(map[currentH-1][currentW]=='.') {
							map[currentH][currentW] = '.';
							currentH--;
							map[currentH][currentW] = '^';
						}
					}
					break;
				case 'D' :
					map[currentH][currentW] = 'v';
					if(currentH+1 < H) {
						if(map[currentH+1][currentW]=='.') {
							map[currentH][currentW] = '.';
							currentH++;
							map[currentH][currentW] = 'v';
						}
					}
					break;
				case 'L' :
					map[currentH][currentW] = '<';
					if(currentW-1 >= 0) {
						if(map[currentH][currentW-1]=='.') {
							map[currentH][currentW] = '.';
							currentW--;
							map[currentH][currentW] = '<';
						}
					}
					break;
				case 'R' :
					map[currentH][currentW] = '>';
					if(currentW+1 < W) {
						if(map[currentH][currentW+1]=='.') {
							map[currentH][currentW] = '.';
							currentW++;
							map[currentH][currentW] = '>';
						}
					}
					break;
				case 'S' :
					
					switch(map[currentH][currentW]) {
					case '^' :
						for(int k = currentH - 1; k >= 0; k--) {
							if(map[k][currentW] == '*') {
								map[k][currentW] = '.';
								break;
							}
							if(map[k][currentW] == '#') break;
						}
						break;
					case 'v' :
						for(int k = currentH + 1; k < H; k++) {
							if(map[k][currentW] == '*') {
								map[k][currentW] = '.';
								break;
							}
							if(map[k][currentW] == '#') break;

						}
						break;
					case '<' :
						for(int k = currentW - 1; k >= 0; k--) {
							if(map[currentH][k] == '*') {
								map[currentH][k] = '.';
								break;
							}
							if(map[currentH][k] == '#') break;

						}
						break;
					case '>' :
						for(int k = currentW + 1; k < W; k++) {
							if(map[currentH][k] == '*') {
								map[currentH][k] = '.';
								break;
							}
							if(map[currentH][k] == '#') break;
						}
						break;
					
					}
					
					
				}
			}
			
			sb.append("#").append(t+1).append(" ");
			for(int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
			
			
			
		}
		
		System.out.print(sb);
		
		
		
		
		
		
	}

}
