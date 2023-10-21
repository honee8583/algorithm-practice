package 백준.동적계획법;

import java.util.Scanner;

public class B_2193 {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new long[91][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 0;

        for (int i = 3; i <= 90; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
