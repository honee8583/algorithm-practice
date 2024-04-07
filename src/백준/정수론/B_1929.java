package 백준.정수론;

import java.util.Scanner;

public class B_1929 {
    static int M, N;
    static int[] decimals;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        decimals = new int[N + 1];
        findDecimals();
        printDecimals();
    }

    public static void findDecimals() {
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (decimals[i] == 1) {
                continue;
            }

            for (int j = i * 2; j <= N; j+=i) {
                decimals[j] = 1;    // 소수가 아닌 것은 1
            }
        }
    }

    public static void printDecimals() {
        for (int i = M; i <= N; i++) {
            if (i == 1) {
                continue;
            }

            if (decimals[i] != 1) {
                System.out.println(i);
            }
        }
    }
}
