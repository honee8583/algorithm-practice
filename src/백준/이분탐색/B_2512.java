package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 각 지방의 요청 예산(1 ~ 100000)
        st = new StringTokenizer(bf.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());   // 전체 국가 예산

        int start = 1;
        int end = Arrays.stream(A).max().getAsInt();
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.min(A[i], mid);
            }

            if (sum > M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}
