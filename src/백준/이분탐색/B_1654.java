package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long max = Integer.MIN_VALUE;
        long start = 1;
        long end = Arrays.stream(arr).max().getAsInt();
        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += arr[i] / mid;
            }

            if (sum >= N) {
                max = Math.max(max, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
