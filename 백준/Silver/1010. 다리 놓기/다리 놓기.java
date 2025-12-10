import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[31][31];
        for (int i = 1;i < 31;i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        // dp[i][j] = dp[i - *][j - 1];
        for (int i = 2;i < 31;i++) {
            for (int j = 2;j < i;j++) {
                int sum = 0;
                for (int k = 1;k < i;k++) {
                    sum += dp[k][j - 1];
                }
                dp[i][j] = sum;
            }
        }

        // for (int i = 0;i < 31;i++) {
        //     for (int j = 0;j < 31;j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println(Arrays.deepToString(dp));

        StringTokenizer st;
        for (int i = 0;i < T;i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(dp[M][N]);
        }
    }
}