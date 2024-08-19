package 백준.동적계획법;

import java.io.*;

public class B_2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result;
        if (N == 1) {
            result = arr[1];
        } else if (N == 2) {
            result = arr[1] + arr[2];
        } else {
            int[] dp = new int[N + 1];
            dp[1] = arr[1];
            dp[2] = dp[1] + arr[2];
            for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]), dp[i - 1]);
            }

            result = dp[N];
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
