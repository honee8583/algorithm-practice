package 백준.동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_2579 {
    static int[] DP, stairs;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        stairs = new int[301];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        DP = new int[301];
        DP[1] = stairs[1];
        DP[2] = stairs[1] + stairs[2];  // 계단이 2개일때는 첫번째 두번째 모두 더해야 한다.
        DP[3] = Math.max(stairs[1], stairs[2]) + stairs[3];     // 계단이 3개일 때는 (첫번째 + 세번째) vs (두번째 + 세번째)

        for (int i = 4; i <= 300; i++) {
            // 1. 2계단 + 1계단
            // 2. 한번에 2계단
            DP[i] = Math.max(DP[i - 3] + stairs[i - 1], DP[i - 2]) + stairs[i];
        }

        bw.write(DP[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
