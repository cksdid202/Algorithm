import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            String input = br.readLine();
            
            int count = 0; 
            int sum = 0;   

            for (int j = 0; j < input.length(); j++) {
                
                if (input.charAt(j) == 'O') {
                    count++;      
                    sum += count; 
                } else {
                    count = 0;    
                }
            }
            
         
            sb.append(sum).append('\n');
        }
        
        System.out.print(sb);
    }
}