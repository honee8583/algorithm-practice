package 백준;

import java.io.IOException;
import java.util.Scanner;

public class B_2343 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];

        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            if (start < A[i]) start = A[i];
            end = end + A[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (sum + A[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum = sum + A[i];
            }

            if (sum != 0) {
                cnt++;
            }

            if (cnt > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
