import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] zero = new long[N + 1];
        long[] one = new long[N + 1];
        zero[1] = 0;
        one[1] = 1;
        for (int i = 2; i <= N; i++) {
            zero[i] = one[i - 1] + zero[i - 1];
            one[i] = zero[i - 1];
        }

        System.out.println(zero[N] + one[N]);
    }
}