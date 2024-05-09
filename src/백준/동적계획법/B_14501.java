package 백준.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] T = new int[N + 1];   // 날짜 배열
        int[] P = new int[N + 1];   // 금액 배열
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            T[i] = t;
            P[i] = p;
        }

//        System.out.println(Arrays.toString(T));
//        System.out.println(Arrays.toString(P));

        int[] DP = new int[N + 2];  // i번째날부터 퇴사일까지 벌 수 있는 최대 금액
        for (int i = N; i > 0; i--) {
            // 퇴사일까지 못 끝내는 경우
            if (i + T[i] > N + 1) {
                DP[i] = DP[i + 1];
            } else {
                // 퇴사일안에 끝낼 수 있는 경우
                // ** 다음날부터 벌 수 있는 최대 금액과 비교를 해야 한다.
                DP[i] = Math.max(DP[i + 1], DP[i + T[i]] + P[i]);
            }
        }

//        System.out.println(Arrays.toString(DP));
        System.out.println(DP[1]);
    }
}
