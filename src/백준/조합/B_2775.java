package 백준.조합;

import java.util.Arrays;
import java.util.Scanner;

public class B_2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[][] dp = new int[15][15];

            // 초기화
            for (int j = 0; j <= 14; j++) {
                dp[0][j] = j;
                dp[j][1] = 1;
            }

            // 점화식 사용
            for (int j = 1; j <= 14; j++) { // 층
                for (int l = 2; l <= 14; l++) { // 호
//                    int sum = 0;
//                    for (int m = 1; m <= l; m++) {
//                        sum += dp[j - 1][m];
//                    }
//                    dp[j][l] = sum;
                    dp[j][l] = dp[j][l - 1] + dp[j - 1][l];
                }
            }

//            System.out.println(Arrays.deepToString(dp));

            System.out.println(dp[k][n]);
        }
    }
}
