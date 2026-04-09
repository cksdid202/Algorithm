import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int revA = Integer.parseInt(new StringBuilder(A).reverse().toString());
        int revB = Integer.parseInt(new StringBuilder(B).reverse().toString());

        System.out.println(revA > revB ? revA : revB);
    }
}