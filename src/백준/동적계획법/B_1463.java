package 백준.동적계획법;

import java.util.Scanner;

public class B_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] DP = new int[N + 1];
        DP[1] = 0;
        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i - 1] + 1;  // 1을 빼는 연산
            if (i % 2 == 0) DP[i] = Math.min(DP[i], DP[i / 2] + 1); // 2로 나누는 연산
            if (i % 3 == 0) DP[i] = Math.min(DP[i], DP[i / 3] + 1); // 3으로 나누는 연산
        }

        System.out.println(DP[N]);
    }
}
