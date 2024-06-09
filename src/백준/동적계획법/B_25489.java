package 백준.동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_25489 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int R, C, W;
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        W = Integer.parseInt(input[2]);

        int[][] DP = new int[31][31];
        DP[1][1] = 1;

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j <= i; j++) {
                DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
            }
        }

        int sum = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j <= i; j++) {
                sum += DP[R + i][C + j];
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
