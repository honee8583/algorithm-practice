import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        int cnt = 0;
        int start = 0;
        int end = 1;
        while (start <= end) {
            int tmp = 0;
            for (int i = start; i <= end; i++) {
                tmp += arr[i];
            }

            if (tmp == N) {
                cnt++;
                start++;
            } else if (tmp < N) {
                end++;
            } else if (tmp > N) {
                start++;
            }
        }

        System.out.println(cnt);
    }
}