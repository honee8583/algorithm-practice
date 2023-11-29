package 백준.그리디;

import java.util.Arrays;
import java.util.Scanner;

public class B_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int result = 0;
        while (K != 0) {
            int i = 0;
            for (i = 0; i < N; i++) {
                if (A[i] > K) {
                    break;
                }
            }
            i--;

            result += K / A[i];
            K %= A[i];
        }

        System.out.println(result);
    }
}
