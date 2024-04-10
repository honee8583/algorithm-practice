package 백준.그리디;

import java.util.Arrays;
import java.util.Scanner;

public class B_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= K) {
                cnt += K / coins[i];
                K %= coins[i];
            }
        }

        System.out.println(cnt);
    }
}
