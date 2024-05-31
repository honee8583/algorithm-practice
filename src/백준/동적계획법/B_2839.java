package 백준.동적계획법;

import java.util.Arrays;
import java.util.Scanner;

public class B_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        final int INF = 9999;

        int[] DP = new int[5001];
        Arrays.fill(DP, INF);
        DP[3] = 1;
        DP[5] = 1;

        for (int i = 6; i < DP.length; i++) {
            DP[i] = Math.min(DP[i - 3] + 1, DP[i - 5] + 1);
        }

        if (DP[N] >= INF) {
            System.out.println("-1");
        } else {
            System.out.println(DP[N]);
        }
    }
}
