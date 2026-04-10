import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int M = sc.nextInt();

        A += M/60;
        B += M%60;

        if (B >= 60) {
            A++;
            B -= 60;
        }
        if (A >= 24) {
            A -= 24;
        }
        System.out.println(A + " " + B);

        sc.close();
    }
}

