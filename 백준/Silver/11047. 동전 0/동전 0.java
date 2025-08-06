import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            int num = arr[i];
            if (num <= K) {
                cnt += K / num;
                K %= num;
            }
        }

        System.out.println(cnt);
    }
}