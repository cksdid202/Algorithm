
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int result = 0;
			
			for(int i=1; i<N-1; i++) {
				// 봉우리를 찾으면
				if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
					
					// 왼쪽 내려가면서 개수 세기
					int tmp = i;
					int cnt1 = 0;
					while(tmp > 0) {
						if(arr[tmp-1] < arr[tmp]) {
							cnt1++;
							tmp--;
						}
						else break;
					}
					
					// 오른쪽 내려가면서 개수 세기
					int tmp2 = i;
					int cnt2 = 0;
					while(tmp2 < N-1) {
						if(arr[tmp2+1] < arr[tmp2]) {
							cnt2++;
							tmp2++;
							
						}
						else break;
						
					}
					// 오른쪽 내리막 끝난 시점으로 점프
					i = tmp2-1;
					
					result += cnt1 * cnt2;
					
					
				}
				
			}
			
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
			
			
		}
		
		System.out.println(sb);
		
		
	}

}


 
