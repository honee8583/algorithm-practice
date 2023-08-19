package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());   // ~10,000(만)
        int N = Integer.parseInt(st.nextToken());   // ~1000,000(백만)

        int[] lines = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            lines[i] = Integer.parseInt(st.nextToken());
        }

        long result = -1;

        long start = 1;
        long end = Arrays.stream(lines).max().getAsInt();
        while (start <= end) {
            long mid = start + (end - start) / 2;

            int sum = 0;    // 만들어지는 랜선의 개수
            for (int i = 0; i < lines.length; i++) {
                sum += lines[i] / mid;
            }

            if (sum == N) {
                result = Math.max(result, mid);
                start = mid + 1;
            } else if (sum < N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        result = Math.max(result, end);
        System.out.println(result);
    }
}
