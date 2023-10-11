package 백준.조합;

import java.util.Scanner;

public class B_1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int [][] dp = new int[31][31];

            // 초기화
            for (int j = 1; j <= 30; j++) {
                dp[j][j] = 1;
                dp[1][j] = j;
            }

            // 점화식 사용
            for (int j = 2; j <= 30; j++) {
                for (int k = j + 1; k <= 30; k++) {
                    dp[j][k] = dp[j - 1][k - 1] + dp[j][k - 1];
                }
            }

            System.out.println(dp[N][M]);
        }
    }
}
