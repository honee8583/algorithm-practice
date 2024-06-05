package 백준.동적계획법;

import java.io.*;
import java.util.*;

public class B_11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] seq = new int[N];
        for (int i = 0; i < input.length; i++) {
            seq[i] = Integer.parseInt(input[i]);
        }

        int[] DP = new int[N];
        for (int i = 0; i < N; i++) {
            DP[i] = 1;

            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && DP[i] < DP[j] + 1) {
                    DP[i] = DP[j] + 1;
                }
            }
        }

        bw.write(Arrays.stream(DP).max().getAsInt() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
