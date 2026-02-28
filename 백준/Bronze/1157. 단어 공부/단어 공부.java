import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine().toUpperCase();
        
        int[] count = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            count[c - 'A']++; 
        }
        
        int max = -1; 
        char answer = '?'; 
        
        for (int i = 0; i < 26; i++) {
            
            if (count[i] > max) {
                max = count[i];
                answer = (char) (i + 'A'); 
            } 
            else if (count[i] == max) {
                answer = '?';
            }
        }
        
        System.out.println(answer);
    }
}