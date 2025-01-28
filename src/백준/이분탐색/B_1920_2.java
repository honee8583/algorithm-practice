package 백준.이분탐색;

import java.io.*;
import java.util.*;

public class B_1920_2 {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            boolean result = binarySearch(target);
            if (result) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean binarySearch(int target) {
        // 5 -> 0, 1, |2|, 3, 4
        // 4 -> 0, |1|, 2, 3

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {  // start == end 인곳 (즉 한원소만 남았을 때)도 체크해야함!
            int mid = (start + end) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
