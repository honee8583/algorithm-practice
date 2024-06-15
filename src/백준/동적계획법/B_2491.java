package 백준.동적계획법;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2491 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] inc = new int[N + 1];
        inc[0] = 1;

        int[] dec = new int[N + 1];
        dec[0] = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }

        for (int i = 1; i < N; i++) {
            if (arr[i] <= arr[i - 1]) {
                dec[i] = dec[i - 1] + 1;
            } else {
                dec[i] = 1;
            }
        }

        int max1 = Arrays.stream(inc).max().getAsInt();
        int max2 = Arrays.stream(dec).max().getAsInt();
        int result = Math.max(max1, max2);

        System.out.println(result);
    }
}
