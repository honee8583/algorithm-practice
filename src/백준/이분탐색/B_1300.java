package 백준.이분탐색;

import java.util.Scanner;

public class B_1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int start = 1;
        int end = K;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += Math.min(N, mid / i);
            }

            if (sum < K) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
