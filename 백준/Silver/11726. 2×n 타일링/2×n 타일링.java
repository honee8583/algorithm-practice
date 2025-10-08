import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2 ;
        for (int i = 3; i < 1001; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }

        System.out.println(dp[N]);
    }
}