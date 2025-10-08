import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] DP = new int[1001];
        DP[1] = 1;
        DP[2] = 3;
        for (int i = 3;i < 1001;i++) {
            DP[i] = (DP[i - 2] * 2 + DP[i - 1]) % 10007;
        }

        System.out.println(DP[N]);
    }
}