package 백준.동적계획법;

import java.util.Scanner;

public class B_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] A = new long[1001];
        A[1] = 1;
        A[2] = 2;
        for (int i = 3; i <= 1000; i++) {
            A[i] = (A[i - 2] + A[i - 1]) % 10007;
        }

        System.out.println(A[n]);
    }
}
