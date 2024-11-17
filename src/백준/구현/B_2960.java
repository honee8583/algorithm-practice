package 백준.구현;

import java.util.Scanner;

public class B_2960 {
    static boolean[] arr;
    static int N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        arr = new boolean[N + 1];
        System.out.println(checkK());
    }

    private static int checkK() {
        int cnt = 0;  // 지운 횟수
        for (int i = 2; i <= N; i++) {
            int idx = i;
            while (idx <= N) {
                if (!arr[idx]) {
                    arr[idx] = true;
                    cnt++;
                }

                if (cnt == K) {
                    return idx;
                }
                idx += i;
            }
        }
        return -1;
    }
}
