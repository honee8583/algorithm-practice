package 백준.정수론;

import java.util.Scanner;

public class B_1456 {
    static long A, B;
    static int[] decimals;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();

        decimals = new int[10000001];
        for (int i = 2; i < 10000001; i++) {
            decimals[i] = i;
        }
        findDecimals();

        int cnt = 0;
        for (int i = 2; i < 10000001; i++) {
            if (decimals[i] != 0) {
                long temp = decimals[i];
                while ((double) decimals[i] <= (double) B / temp) { // long형의 범위를 넘어설 수 있기 때문에
                    if ((double) decimals[i] >= (double) A / temp) {    // decimals[i] * temp >= A 와 같으므로 N제곱부터 시작하는것과 같다.
                        cnt++;
                    }
                    temp *= decimals[i];
                }
            }
        }

        System.out.println(cnt);
    }

    public static void findDecimals() {
        for (int i = 2; i <= Math.sqrt(decimals.length); i++) {
            if (decimals[i] == 0) {
                continue;
            }

            for (int j = i * 2; j < decimals.length; j+=i) {
                decimals[j] = 0;
            }
        }
    }
}
