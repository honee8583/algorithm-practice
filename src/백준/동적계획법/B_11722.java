package 백준.동적계획법;

import java.io.*;
import java.util.*;

public class B_11722 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[N + 1];
        DP[1] = 1;
        for (int i = 2; i <= N; i++) {
            DP[i] = 1;
            for (int j = 1; j < i; j++) {
                // 전 숫자보다 작고 DP 값 또한 작거나 같을 경우 전 DP 값 + 1로 업데이트
                if (arr[i] < arr[j] && DP[i] <= DP[j]) {
                    DP[i] = DP[j] + 1;
                // 그렇지 않고 현재 값과 이전 값이 같을 경우 이전 DP 값과 동일하게 업데이트
                } else if (arr[i] == arr[j]) {
                    DP[i] = DP[j];
                }
            }
        }

//        bw.write(Arrays.toString(DP) + "\n");
        bw.write(Arrays.stream(DP).max().getAsInt() + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
