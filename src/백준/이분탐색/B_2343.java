package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        long[] A = new long[N];
        long start = 0;
        long end = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
            if (start < A[i]) start = A[i];
            end = end + A[i];
        }

        while (start <= end) {
            long mid = start + (end - start) / 2;

            int cnt = 0;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (sum + A[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += A[i];
            }
            if (sum != 0) cnt++;

            if (cnt > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
