package 백준.동적계획법;

import java.util.*;

public class B_2193_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] one = new long[N + 1];
        long[] zero = new long[N + 1];
        one[1] = 1;
        zero[1] = 0;

        for (int i = 2; i <= N; i++) {
            one[i] += zero[i - 1];
            zero[i] += zero[i - 1] + one[i - 1];
        }

        System.out.println(Arrays.toString(one));
        System.out.println(Arrays.toString(zero));

        System.out.println(one[N] + zero[N]);
    }
}
