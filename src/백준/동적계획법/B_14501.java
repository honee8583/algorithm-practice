package 백준.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // 걸리는 시간배열, 수입배열 초기화
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] A = new int[N + 2];
        for (int i = N; i >= 1; i--) {
            if (i + T[i] > N + 1) { // 퇴사날짜를 넘기는 경우
                A[i] = A[i + 1];
            } else {    // 퇴사날짜를 넘기지 않는 경우
                A[i] = Math.max(A[i + 1], A[i + T[i]] + P[i]);
            }
        }

        System.out.println(A[1]);
    }
}
