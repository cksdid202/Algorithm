import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char [][] arr = new char[5][15];
		for(int i=0; i < 5; i++) {
			String line = br.readLine();
			
			for(int j=0; j<line.length();j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 5; j++) {
				if(arr[j][i] != '\0') {
					sb.append(arr[j][i]);
				}
				
			}
		}
		
		System.out.println(sb);
		
	}

}