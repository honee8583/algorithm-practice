package 백준.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입정렬
        for (int i = 1; i < N; i++) {
            int cur = P[i];
            int j = i - 1;
            while (j < i && j >= 0) {
                if (P[j] > cur) {
                    P[j + 1] = P[j];
                    j--;
                } else {
                    break;
                }
            }
            P[j + 1] = cur;
        }

        // 합배열
        int[] S = new int[N];
        S[0] = P[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + P[i];
        }
        System.out.println(Arrays.stream(S).sum());
    }
}
