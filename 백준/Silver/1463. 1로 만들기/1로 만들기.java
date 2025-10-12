import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];
        dp[N] = 0;
        dp[N - 1] = 1;

        for (int i = N - 2; i >= 1; i--) {
            int M = Integer.MAX_VALUE;

            if (i * 3 <= N) {
                M = Math.min(dp[i * 3] + 1, M);
            }
            
            if (i * 2 <= N) {
                M = Math.min(dp[i * 2] + 1, M);
            }

            if (i + 1 <= N) {
                M = Math.min(dp[i + 1] + 1, M);
            }

            dp[i] = M;
        }

        System.out.println(dp[1]);
    }
}