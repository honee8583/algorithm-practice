import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        final int MAX_SIZE = 100;
        final int NUM_SIZE = 10;
        final long MOD = 1000000000;

        long[][] dp = new long[MAX_SIZE + 1][NUM_SIZE];
        for (int i = 1; i < NUM_SIZE; i++) {
            dp[1][i] = 1;  // 1자리수의 1 ~ 9로 끝나는 수의 개수는 모두 1씩
        }

        for (int i = 2; i <= MAX_SIZE; i++) {
            dp[i][0] = dp[i - 1][1];  // 0
            for (int j = 1; j < NUM_SIZE - 1; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;  // 1 ~ 8
            }
            dp[i][9] = dp[i - 1][8];  // 9
        }

        System.out.println(Arrays.stream(dp[N]).sum() % MOD);
    }
}