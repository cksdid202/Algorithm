
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[] LED = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			
			LED[i] = Integer.parseInt(st.nextToken());
		
		}
		
		int students = Integer.parseInt(br.readLine());
		
		int[][] stInfo = new int[students][2];
		for(int i=0; i < students; i++) {
			st = new StringTokenizer(br.readLine());
			
			stInfo[i][0] = Integer.parseInt(st.nextToken());
			stInfo[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		for(int i=0; i < students; i++) {
			
			int k = 0;
			if(stInfo[i][0] == 1) { // 남자면
				for(int j = 1; j <= N; j++) { // LED에서
					if(j % stInfo[i][1] == 0) { // 번호가 배수면 상태바꾸기
						if(LED[j] == 1) {
							LED[j] = 0;
						}
						else {
							LED[j] = 1;
						}
					}
				}
			}
			else { // 여자면
				while(stInfo[i][1] - k > 0 && stInfo[i][1] + k <= N) { // isIn
					if(LED[stInfo[i][1]-k] == LED[stInfo[i][1]+k]) { // 대칭이면
						if(k==0) { // 0일때는 자기만 바꿈
							if(LED[stInfo[i][1]] == 1) {
								LED[stInfo[i][1]] = 0;
							}
							else {
								LED[stInfo[i][1]] = 1;
							}
						}
						else { // 그 외 대칭일때
							if(LED[stInfo[i][1]-k] == 1) {
								LED[stInfo[i][1]-k] = 0;
							}
							else {
								LED[stInfo[i][1]-k] = 1;
							}
							if(LED[stInfo[i][1]+k] == 1) {
								LED[stInfo[i][1]+k] = 0;
							}
							else {
								LED[stInfo[i][1]+k] = 1;
							}
						}
					}
					else // 대칭 아니면 끝
						break;
					k++;
				}
			}
			
			
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(LED[i] + " ");
			if(i%20 == 0) {
				System.out.print("\n");
			}
		}
		
		
		
	}

}
