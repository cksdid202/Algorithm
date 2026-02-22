import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 배달해야 할 설탕의 무게
        int count = 0; // 봉지의 수

        while (N > 0) {
            if (N % 5 == 0) {
                count += N / 5;
                N = 0;
                break;
            }
            
            N -= 3;
            count++;
        }

        if (N < 0) {
            System.out.println("-1");
        } else {
            System.out.println(count);
        }
    }
}