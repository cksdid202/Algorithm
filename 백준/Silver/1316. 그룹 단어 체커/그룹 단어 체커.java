import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); 
        int count = 0; 

        for (int i = 0; i < N; i++) {
            if (check(br.readLine())) {
                count++;
            }
        }
        
        System.out.println(count);
    }

    public static boolean check(String str) {
        boolean[] visited = new boolean[26]; 
        int prev = 0; // 직전 문자 저장용 변수

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i); 

            if (prev != now) {
                
                if (visited[now - 'a'] == false) {
                    visited[now - 'a'] = true;
                    prev = now; 
                } else {
                    return false;
                }
            }
            
            else {
                continue;
            }
        }
        
        return true;
    }
}