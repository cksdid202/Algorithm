import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                
                if (c + 13 > 'Z') {
                    c -= 13; 
                } else {
                    c += 13;
                }
            }
            else if (c >= 'a' && c <= 'z') {
                if (c + 13 > 'z') {
                    c -= 13;
                } else {
                    c += 13;
                }
            }
            
            sb.append(c);
        }

        System.out.println(sb);
    }
}