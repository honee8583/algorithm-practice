package 백준.동적계획법;

import java.util.Scanner;

public class B_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] DP = new int[N + 1];
        DP[1] = 1;

        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (i == j * j) {
                    DP[i] = 1;
                    break;
                } else {
                    min = Math.min(min, DP[i - j * j]);
                    DP[i] = min + 1;
                }
            }
        }

        System.out.println(DP[N]);
    }
}
