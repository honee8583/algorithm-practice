package 백준.동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B_9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        long[] DP = new long[101];
        DP[1] = 1;
        DP[2] = 1;
        DP[3] = 1;
        for (int i = 4; i < 101; i++) {
            DP[i] = DP[i - 2] + DP[i - 3];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(DP[N] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
