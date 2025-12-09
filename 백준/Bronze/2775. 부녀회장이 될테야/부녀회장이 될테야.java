import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0;t < T;t++) {
            int K = sc.nextInt();  // k층
            int N = sc.nextInt();  // N호

            int[][] dp = new int[K + 1][N + 1];
            for (int i = 1;i <= N;i++) {
                dp[0][i] = i;
            }

            for (int i = 1;i <= K;i++) {
                for (int j = 1;j <= N;j++) {
                    int sum = 0;
                    for (int k = 1;k <= j;k++) {
                        sum += dp[i - 1][k];
                    }
                    dp[i][j] = sum;
                }
            }

            System.out.println(dp[K][N]);
        }
    }
}