package 백준.동적계획법;

import java.util.*;

public class B_17212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] DP = new int[100001];
        DP[1] = 1;
        DP[2] = 1;
        DP[3] = 2;
        DP[4] = 2;
        DP[5] = 1;
        DP[6] = 2;
        DP[7] = 1;
        for (int i = 8; i < 100001; i++) {
            DP[i] = Math.min(DP[i - 1], Math.min(DP[i - 1], Math.min(DP[i - 5], DP[i - 7]))) + 1;
        }

        System.out.println(DP[N]);
    }
}
