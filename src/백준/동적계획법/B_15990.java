package 백준.동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_15990 {
    static final long mod = 1000000009;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine());

        long[][] DP = new long[100001][4];
        DP[1][1] = 1;
        DP[2][2] = 1;
        DP[3][1] = 1;
        DP[3][2] = 1;
        DP[3][3] = 1;

        for (int j = 4; j <= 100000; j++) {
            DP[j][1] = (DP[j - 1][2] + DP[j - 1][3]) % mod;
            DP[j][2] = (DP[j - 2][1] + DP[j - 2][3]) % mod;
            DP[j][3] = (DP[j - 3][1] + DP[j - 3][2]) % mod;
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write((DP[N][1] + DP[N][2] + DP[N][3]) % mod + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
