package 백준.동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10211 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
            }

            int[] DP = new int[N];  // 현재 인덱스의 값을 포함하는 최대값
            DP[0] = arr[0];
            for (int j = 1; j < N; j++) {
                DP[j] = Math.max(DP[j - 1] + arr[j], arr[j]);
            }

            bw.write(Arrays.stream(DP).max().getAsInt() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
