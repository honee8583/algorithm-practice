package 백준.투포인터;

import java.util.Scanner;

public class B_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int i = 1;
        int j = i;
        int cnt = 0;
        while (i <= j && i > 0 && j <= N) {
            long sum = 0;
            for (int k = i; k <= j; k++) {
                sum += k;
            }

            if (sum == N) {
                cnt++;
                i++;
                j++;
            } else if (sum < N) {
                j++;
            } else {
                i++;
            }
        }

        System.out.println(cnt);
    }
}
