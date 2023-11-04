package 백준.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        int[] A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int i = 1;
        int j = N;
        int cnt = 0;
        while (i < j) {
            int sum = A[i] + A[j];

            if (sum == M) {
                cnt++;
                i++;
                j--;
            } else if (sum < M) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println(cnt);
        bf.close();
    }
}
