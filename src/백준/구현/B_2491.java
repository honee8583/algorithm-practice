package 백준.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2491 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int max1 = 2;
        int max2 = 2;
        int inc = 1;
        int dec = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i - 1]) {
                inc++;
            } else {
                max1 = Math.max(max1, inc);
                inc = 1;
            }

            if (arr[i] <= arr[i - 1]) {
                dec++;
            } else {
                max2 = Math.max(max2, dec);
                dec = 1;
            }
            // 끝까지 도달한경우
            if (i == N - 1) {
                max1 = Math.max(max1, inc);
                max2 = Math.max(max2, dec);
            }
        }

        System.out.println(Math.max(max1, max2));
    }
}
