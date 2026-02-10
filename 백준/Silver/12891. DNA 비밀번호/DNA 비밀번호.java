
import java.io.*;
import java.util.*;

public class Main {
    static int S, P;
    static int[] checkArr; // 비밀번호 필수 개수 (
    static int[] myArr;    // 현재 윈도우의 개수 
    static int checkSecret; // 조건을 만족하는 문자 개수 (0~4)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
        P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이 (윈도우 크기)

        char[] A = br.readLine().toCharArray(); // DNA 문자열
        
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) checkSecret++;
        }

        int result = 0;

        // 1. 첫 번째 윈도우 초기화
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }

        // 첫 번째 윈도우 검사
        if (checkSecret == 4) result++;

        // 슬라이딩 윈도우 
        for (int i = P; i < S; i++) {
            int j = i - P; 
            
            Add(A[i]);    // 오른쪽 문자 추가
            Remove(A[j]); // 왼쪽 문자 제거
            
            if (checkSecret == 4) result++;
        }

        System.out.println(result);
    }

    // 문자 추가
    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }

    // 문자 제거
    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
