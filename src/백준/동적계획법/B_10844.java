package 백준.동적계획법;

import java.util.Scanner;

public class B_10844 {
    static int mod = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][] A = new long[N + 1][10];
        for (int i = 1; i < 10; i++) {
            A[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            A[i][0] = A[i - 1][1];
            A[i][9] = A[i - 1][8];
            for (int j = 1; j <= 8; j++) {
                A[i][j] = A[i - 1][j - 1] + A[i - 1][j + 1];
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + A[N][i]) % mod;
        }
        System.out.println(sum);
    }
}
