import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            
            if (binarySearch(arr, target)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // 교차하기 전까지 
        while (left <= right) {
            int mid = (left + right) / 2; 

            if (arr[mid] == target) {
                return true; // 찾음!
            } 
            else if (arr[mid] > target) {
                // 중간값보다 찾고자 하는 값이 작으면, 왼쪽 구간으로 좁힘
                right = mid - 1;
            } 
            else {
                // 반대면 오른쪽
                left = mid + 1;
            }
        }
        
        return false; // 다 찾아봤는데 없음
    }
}