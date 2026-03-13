
import java.util.*;
import java.io.*;

public class Solution {
	
	public static int[] gArr;
	public static int[] iArr;
	public static int[] numbers = new int [9];
	public static StringBuilder sb = new StringBuilder();
	public static int winCnt = 0;
	public static int loseCnt = 0;


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
				
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean[] picked = new boolean[19];
			
			gArr = new int[9];
			iArr = new int[9];
			
			for(int i = 0; i < 9; i++) {
				gArr[i] = Integer.parseInt(st.nextToken());
				picked[gArr[i]] = true;
			}
			for(int i = 1, j = 0; i <= 18; i++) {
				if(!picked[i]) {
					iArr[j] = i;
					j++;
				}
			}
			
			soonyeol(0, new boolean [9]);
			sb.append("#").append(t).append(" ").append(winCnt).append(" ").append(loseCnt).append("\n");

			
			winCnt = 0;
			loseCnt = 0;
			
		}
		System.out.print(sb);
		
		
	}
	
	public static void soonyeol(int cnt, boolean[] isSelected) {
		
		if(cnt == 9) {
			
			int gCnt = 0;
			int iCnt = 0;
			for(int j = 0; j < 9; j++) {
				if(numbers[j] < gArr[j] ) {
					gCnt += numbers[j] + gArr[j]; 
				}
				else {
					iCnt += numbers[j] + gArr[j]; 
				}
			}
			
			if(gCnt > iCnt) {
				winCnt++;
			}
			else {
				loseCnt++;
			}
			
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			
			if(isSelected[i]) {
				continue;
			}
			numbers[cnt] = iArr[i];
			isSelected[i] = true;
			soonyeol(cnt+1, isSelected);
			isSelected[i] = false; 
			
			
		}
		
		
		
	}
	
	
	
	
	
	

}
