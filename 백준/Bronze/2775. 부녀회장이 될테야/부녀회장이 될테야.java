import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[][] dp = new int[15][15];
        for (int i = 1;i < 15;i++) {
            dp[0][i] = i;
            dp[i][1] = 1;
        }

        for (int i = 1;i < 15;i++) {
            for (int j = 2;j < 15;j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }


        for (int t = 0;t < T;t++) {
            int K = sc.nextInt();  // k층
            int N = sc.nextInt();  // N호
            System.out.println(dp[K][N]);
        }
    }
}