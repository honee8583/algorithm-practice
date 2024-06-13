package 백준.동적계획법;

import java.util.Scanner;

public class B_15624 {
    static int N;
    static int[] DP;
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        if (N == 0) {
            System.out.println(0);
            return;
        }

        DP = new int[N + 1];
        DP[0] = 0;
        DP[1] = 1;
        for (int i = 2; i <= N; i++) {
            DP[i] = (DP[i - 2] + DP[i - 1]) % mod;
        }

        System.out.println(DP[N]);
    }
}
