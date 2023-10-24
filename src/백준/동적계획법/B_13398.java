package 백준.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽에서부터 현재 인덱스의 배열값을 포함한 연속된 수들의 최대값 저장
        int[] L = new int[N];
        L[0] = A[0];
        int result = L[0];
        for (int i = 1; i < N; i++) {
            L[i] = Math.max(L[i - 1] + A[i], A[i]);
            result = Math.max(result, L[i]);
        }
        // 오른쪽에서부터 현재 인덱스의 배열값을 포함한 연속된 수들의 최대값 저장
        int[] R = new int[N];
        R[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            R[i] = Math.max(R[i + 1] + A[i], A[i]);
        }
        // 현재 인덱스의 배열값을 제외했을 때의 최대값은 L[i - 1] + R[i + 1] 이다.
        for (int i = 1; i < N - 1; i++) {
            result = Math.max(result, L[i - 1] + R[i + 1]);
        }

        System.out.println(result);
    }
}
