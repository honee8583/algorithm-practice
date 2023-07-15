package DoIt;

import java.util.Scanner;

public class 소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < Math.sqrt(N); i++) {
            // 소수가 아닐경우 continue
            if (arr[i] == 0) {
                continue;
            }

            // 현재 소수일경우
            for (int j = i + i; j <= N; j = j + i) {
                arr[j] = 0;
            }
        }

        // print
        for (int i = M; i <= N; i++) {
            if (arr[i] != 0) {
               System.out.print(arr[i] + " ");
            }
        }
    }
}
