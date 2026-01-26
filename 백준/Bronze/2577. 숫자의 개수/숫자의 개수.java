
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int abc = A*B*C;
        
        int [] cnt = new int[10];
        
        while(abc != 0) {
        	int t = abc % 10;
        	
        	cnt[t]++;
        	
        	abc = abc / 10;
        }
        
        for(int i=0; i < cnt.length; i++) {
        	System.out.println(cnt[i]);
        }

        
    }

   
}
