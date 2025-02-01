package 백준.이분탐색;

import java.io.*;
import java.util.*;

public class B_2805_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 나무의 수
        long M = Long.parseLong(st.nextToken());  // 집으로 가져갈 나무의 길이

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long start = 0;
        long end = Arrays.stream(arr).max().getAsInt(); // 20

        long max = Long.MIN_VALUE;
        while (start <= end) {
            long mid = (start + end) / 2;
            System.out.println("start: " + start + ", end: " + end + ", mid: " + mid);

            long sum = 0;
            for (int i = 0; i < N; i++) {
                long diff = arr[i] - mid;
                if (diff > 0) {
                    sum += diff;
                }
            }
            System.out.println("sum : " + sum);

            if (sum >= M) {  // 적어도 M미터
                max = Math.max(mid, max);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(max);
    }
}
