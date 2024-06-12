package 백준.동적계획법;

import java.util.Scanner;

public class B_13699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] DP = new long[36];
        DP[0] = 1;
        for (int i = 1; i <= 35; i++) {
            for (int j = 0; j < i; j++) {
                DP[i] += DP[j] * DP[i - j - 1];
            }
        }

        System.out.println(DP[N]);
    }
}
