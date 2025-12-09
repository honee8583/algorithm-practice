import java.io.*;
import java.util.*;

class Main {
    static final int MOD = 10007;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        long[][] dp = new long[N + 1][N + 1];
        for (int i = 0;i <= N;i++) {
            dp[i][1] = i;
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 1;i <= N;i++) {
            for (int j = 1;j <= i;j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}