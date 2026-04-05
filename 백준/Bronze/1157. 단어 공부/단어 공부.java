import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase(); 

        int[] alphabet = new int[26]; 

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'A']++;
        }

        int maxCount = -1;
        char result = '?';

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > maxCount) {
                maxCount = alphabet[i];
                result = (char) (i + 'A'); 
            } 
            else if (alphabet[i] == maxCount) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}