package 백준.동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_1003 {
    static int[] zero, one;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        zero = new int[41];
        one = new int[41];
        zero[0] = 1;
        one[0] = 0;
        for (int i = 1; i <= 40; i++) {
            zero[i] = one[i - 1];
            one[i] = zero[i - 1] + zero[i];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(zero[N] + " " + one[N] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
